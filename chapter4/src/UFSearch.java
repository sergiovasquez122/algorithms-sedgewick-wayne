import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class UFSearch {

    private WeightedQuickUnionUF UF;
    private int s;
    public UFSearch(Graph G, int s)
    {
        UF = new WeightedQuickUnionUF(G.V());
        this.s = s;
        for(int i = 0;i < G.V();++i){
            for(int w : G.adj(i)){
                UF.union(i, w);
            }
        }
    }

    boolean marked(int v){
        return UF.connected(s,v);
    }

    int count(){
        return 0;
    }

    public static void main(String[] args) {
        Graph G = new Graph(5);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 3);
        G.addEdge(1, 2);
        G.addEdge(2,3);

        UFSearch ufSearch = new UFSearch(G, 1);
        StdOut.println("Connected to 0: " + ufSearch.marked(0) + " expected: true");
        StdOut.println("Connected to 1: " + ufSearch.marked(1) + " expected: true");
        StdOut.println("Connected to 2: " + ufSearch.marked(1) + " expected: true");
        StdOut.println("Connected to 3: " + ufSearch.marked(3) + " expected: true");
        StdOut.println("Connected to 5: " + ufSearch.marked(4) + " expected: false");
    }
}
