public class WeightedQuickUnionPathCompressionUF {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionPathCompressionUF(int N){
        count = N;
        id = new int[N];
        for(int i = 0;i < N; i++) id[i] = i;
        sz = new int[N];
        for(int i = 0;i < N; i++) sz[i] = 1;
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    private int find(int p){
        int root = p;
        while(root != id[root])
            root = id[root];
        while(p != root){
            int newP = id[p];
            id[p] = root;
            p = newP;
        }
        return root;
    }

    public int count(int s){
        int root = find(s);
        return sz[s];
    }

    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i == j) return;

        if(sz[i] < sz[j]){id[i] = j;sz[j] += sz[i];}
        else {id[j] = i;sz[i] += sz[j];}
        count--;
    }
}

