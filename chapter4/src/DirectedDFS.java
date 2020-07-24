import edu.princeton.cs.algs4.In;

public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public void dfs(Digraph G, int v){
        marked[v] = true;
        for(int w : G.adj(v))
            if(!marked[w]) dfs(G, w);
    }

    public boolean marked(int v){
        return marked[v];
    }
}
