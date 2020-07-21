public class QuickUnionPathCompressionUF {
    private int[] id;
    private int count;

    public QuickUnionPathCompressionUF(int N){
        count = N;
        id = new int[N];
        for(int i = 0;i < N;++i)
            id[i] = i;
    }

    public int count(){
        return count;
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
        return p;
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;

    }
}
