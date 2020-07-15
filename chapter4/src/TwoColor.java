public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph G){
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for(int v = 0;v < G.V();++v){
            if(!marked[v]){
                dfs(G, v);
            }
        }
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for(int w : G.adj(v)){
            if(!marked[v]){
                color[w] = !color[v];
            } else if(color[w] == color[v]) isTwoColorable = false;
        }
    }

    public boolean isBipartite(){
        return isTwoColorable;
    }
}
