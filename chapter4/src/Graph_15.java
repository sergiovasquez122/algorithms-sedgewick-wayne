import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Graph class used to implement
 * exercise 4.1.15
 */
public class Graph_15 {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;


    public Graph_15(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new Bag<>();
        }
    }

    public Graph_15(Graph_15 G) {
        this(G.V);
        for (int v = 0; v < G.V(); ++v) {
            Stack<Integer> elements = new Stack<>();
            for (int w : G.adj(v)) {
                elements.push(w);
            }

            for (int w : elements) {
                adj[v].add(w);
                E++;
            }
        }
        E /= 2;
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : adj(v))
                s += w + " ";
        }
        return s;
    }

    public static void main(String[] args) {
        Graph_15 G = new Graph_15(new In(args[0]));

        StdOut.println(G);

        StdOut.println("Expected:\n" +
                "0: 6 5 2 1\n" +
                "1: 0\n" +
                "2: 0\n" +
                "3: 5 4\n" +
                "4: 6 5 3\n" +
                "5: 4 3 0\n" +
                "6: 4 0\n" +
                "7: 8\n" +
                "8: 7\n" +
                "9: 12 11 10\n" +
                "10: 9\n" +
                "11: 12 9\n" +
                "12: 11 9");
    }

    public Graph_15(In in) {
        this(in.readInt());
        in.readLine();
        while(in.hasNextLine()){
            String[] vertices = in.readLine().split(" ");
            String beginVertex = vertices[0].substring(0, vertices[0].length() - 1); // get rid of the :
            int vertex = Integer.parseInt(beginVertex);
            for(int i = vertices.length - 1;i >= 1;--i){
                adj[vertex].add(Integer.parseInt(vertices[i]));
                E++;
            }
        }
        E /= 2;
    }

    public boolean hasEdge(int v, int w) {
        for (int u : adj(v)) {
            if (u == w) {
                return true;
            }
        }
        return false;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
