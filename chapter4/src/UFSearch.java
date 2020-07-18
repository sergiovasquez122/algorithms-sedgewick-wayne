import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class UFSearch {

    private WeightedQuickUnionUF UF;
    public UFSearch(Graph G, int s){
        UF = new WeightedQuickUnionUF(G.V());
    }

    boolean marked(int v){
        return false;
    }

    int count(){
        return 0;
    }


}
