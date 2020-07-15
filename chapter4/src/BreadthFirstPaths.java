import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private final int s;

    public BreadthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        for(int i = 0;i < G.V();++i)
            distTo[i] = Integer.MAX_VALUE;
        distTo[s] = 0;
        this.s = s;
        bfs(G, s);
    }

    public void bfs(Graph G, int s){
        Queue<Integer> frontier = new Queue<>();
        marked[s] = true;
        frontier.enqueue(s);
        while(!frontier.isEmpty()){
            int v = frontier.dequeue();
            for(int w : G.adj(v)){
                if(!marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;
                    distTo[w] = distTo[v] + 1;
                    frontier.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public int distTo(int v){
        return distTo[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for(int x = v;x != s;x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(12);
        graph.addEdge(8 ,4);
        graph.addEdge(2 ,3);
        graph.addEdge(1 ,11);
        graph.addEdge(0 ,6);
        graph.addEdge(3 ,6);
        graph.addEdge(10 ,3);
        graph.addEdge(7 ,11);
        graph.addEdge(7 ,8);
        graph.addEdge(11 ,8);
        graph.addEdge(2 ,0);
        graph.addEdge(6 ,2);
        graph.addEdge(5 ,2);
        graph.addEdge(5 ,10);
        graph.addEdge(5 ,0);
        graph.addEdge(8 ,1);
        graph.addEdge(4 ,1);

        BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(graph, 0);
        StdOut.println("Distance from 0 to 0: " + breadthFirstPaths.distTo(0) + " Expected: 0");
        StdOut.println("Distance from 0 to 6: " + breadthFirstPaths.distTo(6) + " Expected: 1");
        StdOut.println("Distance from 0 to 10: " + breadthFirstPaths.distTo(10) + " Expected: 2");
        StdOut.println("Distance from 0 to 3: " + breadthFirstPaths.distTo(3) + " Expected: 2");
        StdOut.println("Distance from 0 to 8: " + breadthFirstPaths.distTo(8) + " Expected: 2147483647");
        StdOut.println("Distance from 0 to 9: " + breadthFirstPaths.distTo(9) + " Expected: 2147483647");
    }

}
