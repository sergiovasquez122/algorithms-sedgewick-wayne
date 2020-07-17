import edu.princeton.cs.algs4.Queue;

import java.util.ArrayList;

public class HamiltonCycle {

    private boolean adjMat[][];
    private boolean hasHamiltonCycle;

    public HamiltonCycle(Graph G){
        adjMat = new boolean[G.V()][G.V()];
        for(int i = 0;i < G.V();i++){
            for(int w : G.adj(i)){
                adjMat[i][w] = true;
                adjMat[w][i] = true;
            }
        }

        ArrayList<ArrayList<Integer>> perms = permutation(G.V());
        for(ArrayList<Integer> q : perms){
            boolean traversable = true;
            for(int i = 1;i < q.size();++i){
                int v = q.get(i - 1);
                int w = q.get(i);
                if(!adjMat[v][w]){
                    traversable = false;
                }
            }
            int start = q.get(0);
            int end = q.get(q.size() - 1);
            if(traversable && adjMat[start][end]){
                hasHamiltonCycle = true;
            }
        }
    }

    private ArrayList<ArrayList<Integer>> permutation(int V){
        int[] arr = new int[V];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = 0;i < V;i++)
            arr[i] = i;
        helper(result, arr, 0);
        return result;
    }

    private void helper(ArrayList<ArrayList<Integer>> result, int arr[], int beginIdx){
        if(beginIdx == arr.length){
            ArrayList<Integer> perm = new ArrayList<>();
            for(int i = 0;i < perm.size();++i) {
                perm.add(arr[i]);
            }
            result.add(perm);
        } else {
            for(int i = beginIdx;i < arr.length;++i){
                swap(arr, beginIdx, i);
                helper(result, arr, beginIdx + 1);
                swap(arr, beginIdx, i);
            }
        }
    }

    public void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean hasHamiltonCycle(){
        return hasHamiltonCycle;
    }

    public boolean containsEdge(int u, int v){
        return adjMat[u][v];
    }
}
