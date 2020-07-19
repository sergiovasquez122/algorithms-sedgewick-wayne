public class UF {
    private int[] id;
    private int count;

    public UF(int N){
        count = N;
        id = new int[N];
        for(int i = 0;i < N; i++)
            id[i] = i;
    }

    public int count(){
        return count;
    }

    public int find(int p){
        return 0;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){

    }
}
