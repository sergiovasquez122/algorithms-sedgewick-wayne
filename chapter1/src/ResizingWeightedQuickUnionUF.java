public class ResizingWeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int N;
    private int count;

    public ResizingWeightedQuickUnionUF(int N){
        count = N;
        this.N = N;
        id = new int[N];
        for(int i = 0;i < N; i++) id[i] = i;
        sz = new int[N];
        for(int i = 0;i < N; i++) sz[i] = 1;
    }

    public int count(){
        return count;
    }

    private int find(int p){
        while(p != id[p]) p = id[p];
        return p;
    }

    public int newSite(){
        int[] tempid = new int[N + 1];
        int[] tempsize = new int[N + 1];
        for(int i = 0;i < N;++i){
            tempid[i] = id[i];
            tempsize[i] = sz[i];
        }
        id = tempid;
        sz = tempsize;
        tempid[N] = N;
        tempsize[N] = 1;
        N = N + 1;
        return N;
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
