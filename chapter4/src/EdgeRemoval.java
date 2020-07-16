import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.StdOut;

public class EdgeRemoval {
    private boolean[] marked;
    private int removalVertex;

    public EdgeRemoval(Graph G){
        marked = new boolean[G.V()];
        dfs(G, 0);
    }

    public void dfs(Graph G, int v){
        marked[v] = true;
        boolean allAdjacentMarked = true;
        for(int w : G.adj(v)){
            if(!marked[w]){
                allAdjacentMarked = false;
                dfs(G, w);
            }
        }
        if(allAdjacentMarked){
            removalVertex = v;
        }
    }

    public int removableVertex(){
        return removalVertex;
    }

    public boolean marked(int v){
        return marked[v];
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        EdgeRemoval edgeRemoval = new EdgeRemoval(graph);
        StdOut.println("Vertex that can be removed: " + edgeRemoval.removableVertex() + " Expected: 1");
    }
}
