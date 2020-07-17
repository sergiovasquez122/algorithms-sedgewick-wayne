import edu.princeton.cs.algs4.StdOut;

public class EulerianCycle {
    public boolean containsEulerianCycle;
    private int oddVertices;

    // assumes fully connected graph
    public EulerianCycle(Graph G){
        for(int v = 0;v < G.V(); ++v){
            int degreeOfv = Graph.degree(G, v);
            if(degreeOfv % 2 == 1){
                oddVertices++;
            }
        }

        containsEulerianCycle = (oddVertices == 2 || oddVertices == 0);
    }

    public boolean containsEulerianCycle(){
        return containsEulerianCycle;
    }

    public static void main(String[] args) {
        Graph G = new Graph(10);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 3);
        G.addEdge(1, 3);
        G.addEdge(1, 4);
        G.addEdge(2, 5);
        G.addEdge(2, 9);
        G.addEdge(3, 6);
        G.addEdge(4, 7);
        G.addEdge(4, 8);
        G.addEdge(5, 8);
        G.addEdge(5, 9);
        G.addEdge(6, 7);
        G.addEdge(6, 9);
        G.addEdge(7, 8);
        EulerianCycle cycle = new EulerianCycle(G);
        StdOut.println(cycle.containsEulerianCycle());
    }
}
