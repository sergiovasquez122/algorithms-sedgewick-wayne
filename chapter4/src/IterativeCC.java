import edu.princeton.cs.algs4.Stack;

public class IterativeCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public IterativeCC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        count = 0;
        for(int i = 0;i < G.V();++i){
            if(!marked[i]){
                dfs(G, i);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v){
        Stack<Integer> on_stack = new Stack<>();
        on_stack.push(v);
        while(!on_stack.isEmpty()){
            int curr = on_stack.pop();
            marked[curr] = true;
            id[curr] = count;
            for(int w : G.adj(curr)){
                if(!marked[w]){
                    on_stack.push(w);
                }
            }
        }
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }

    public static void main(String[] args) {

    }
}
