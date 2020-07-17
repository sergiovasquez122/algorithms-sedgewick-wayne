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

        Graph G2 = new Graph(10);
        G2.addEdge(0, 1);
        G2.addEdge(0, 2);
        G2.addEdge(0, 3);
        G2.addEdge(1, 3);
        G2.addEdge(0, 3);
        G2.addEdge(2, 5);
        G2.addEdge(5, 6);
        G2.addEdge(3, 6);
        G2.addEdge(4, 7);
        G2.addEdge(4, 8);
        G2.addEdge(5, 8);
        G2.addEdge(5, 9);
        G2.addEdge(6, 7);
        G2.addEdge(6, 9);
        G2.addEdge(8, 8);
        EulerianCycle cycle2 = new EulerianCycle(G2);
        StdOut.println(cycle2.containsEulerianCycle());

        Graph G3 = new Graph(10);
        G3.addEdge(0, 1);
        G3.addEdge(1, 2);
        G3.addEdge(1, 3);
        G3.addEdge(0, 3);
        G3.addEdge(0, 4);
        G3.addEdge(2, 5);
        G3.addEdge(2, 9);
        G3.addEdge(3, 6);
        G3.addEdge(4, 7);
        G3.addEdge(4, 8);
        G3.addEdge(5, 8);
        G3.addEdge(5, 9);
        G3.addEdge(6, 7);
        G3.addEdge(6, 9);
        G3.addEdge(7, 8);
        EulerianCycle cycle3 = new EulerianCycle(G3);
        StdOut.println(cycle3.containsEulerianCycle());


        Graph G4 = new Graph(10);
        G4.addEdge(4, 1);
        G4.addEdge(7, 9);
        G4.addEdge(6, 2);
        G4.addEdge(7, 3);
        G4.addEdge(5, 0);
        G4.addEdge(0, 2);
        G4.addEdge(0, 8);
        G4.addEdge(1, 6);
        G4.addEdge(3, 9);
        G4.addEdge(6, 3);
        G4.addEdge(2, 8);
        G4.addEdge(1, 5);
        G4.addEdge(9, 8);
        G4.addEdge(4, 5);
        G4.addEdge(4, 7);
        EulerianCycle cycle4 = new EulerianCycle(G4);
        StdOut.println(cycle4.containsEulerianCycle());
    }
}
