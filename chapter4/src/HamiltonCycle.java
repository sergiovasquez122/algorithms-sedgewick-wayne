public class HamiltonCycle {

    private boolean adjMat[][];

    public HamiltonCycle(Graph G){
        adjMat = new boolean[G.V()][G.V()];
        for(int i = 0;i < G.V();i++){
            for(int w : G.adj(i)){
                adjMat[i][w] = true;
                adjMat[w][i] = true;
            }
        }
    }

    public boolean containsEdge(int u, int v){
        return adjMat[u][v];
    }
}
