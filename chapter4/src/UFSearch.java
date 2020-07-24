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


}
