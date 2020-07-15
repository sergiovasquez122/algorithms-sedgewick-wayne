import edu.princeton.cs.algs4.StdOut;

public class ParallelEdgeDetection {
    private int parallelEdges;
    private boolean[] marked;

    public ParallelEdgeDetection(Graph G){
        marked = new boolean[G.V()];
        parallelEdges = 0;
        for(int v = 0;v < G.V(); ++v){
            dfs(G, v);
        }
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for(int w : G.adj(v)){
            if(!marked[w]){
                dfs(G, w);
            } else if(v == w){
                parallelEdges++;
            }
        }
    }

    public int parallelEdges(){
        return parallelEdges;
    }

    public static void main(String[] args) {
        Graph graph1 = new Graph(4);
        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 0);
        ParallelEdgeDetection p1 = new ParallelEdgeDetection(graph1);
        StdOut.println(p1.parallelEdges() + " Expected: 0");

        Graph graph2 = new Graph(4);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 0);
        graph2.addEdge(3, 2);
        ParallelEdgeDetection p2 = new ParallelEdgeDetection(graph2);
        StdOut.println(p2.parallelEdges() + " Expected: 1");

        Graph graph3 = new Graph(4);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 0);
        graph3.addEdge(2, 3);
        graph3.addEdge(3, 2);
        graph3.addEdge(3, 2);
        graph3.addEdge(3, 0);
        ParallelEdgeDetection p3 = new ParallelEdgeDetection(graph3);
        StdOut.println(p3.parallelEdges() + " Expected: 3");
    }
}
