import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public static int degree(Graph G, int v){
        int degree = 0;
        for(int w : G.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph G){
        int max = 0;
        for(int i = 0;i < G.V(); i++){
            max = Integer.max(max, degree(G, i));
        }
        return max;
    }

    public static int avgDegree(Graph G){
        return 2 * G.E / G.V();
    }

    public static int numberOfSelfLoops(Graph G){
        int count = 0;
        for(int v = 0;v < G.V(); ++v)
            for(int w : G.adj(v))
                if(v == w) count++;
        return count / 2;
    }

    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int i = 0;i < V; ++i){
            adj[i] = new Bag<>();
        }
    }

    public Graph(Graph G){
        this(G.V);
        for(int v = 0;v < G.V();++v){
            Stack<Integer> elements = new Stack<>();
            for(int w : G.adj(v)){
                elements.push(w);
            }

            for(int w : elements){
                adj[v].add(w);
                E++;
            }
        }
        E /= 2;
    }

    public String toString(){
        String s = V + " vertices, " + E + " edges\n";
        for(int v = 0;v < V; v++){
            s += v + ": ";
            for(int w : adj(v))
                s += w + " ";
        }
        return s;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);

        StdOut.println(graph);

        StdOut.println("Expected:\n" +
                "0: 3 2 1\n" +
                "1: 4 2 0\n" +
                "2: 3 1 0\n" +
                "3: 2 0\n" +
                "4: 1\n");

        Graph graph2 = new Graph(graph);

        System.out.println(graph2);
   }

    public Graph(In in){
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0;i < E; ++i){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public boolean hasEdge(int v, int w){
        for(int u : adj(v)){
            if(u == w){
                return true;
            }
        }
        return false;
    }

    public int V(){return V;}

    public int E(){return E;}

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}
