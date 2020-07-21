/**
 * The union operation either doesn't change
 * the height of the tree or increase the height by
 * one. 
 */
public class WeightedQuickUnionByHeightUF {
    private int[] id;
    private int[] height;
    private int count;

    public WeightedQuickUnionByHeightUF(int N){
        count = N;
        id = new int[N];
        for(int i = 0;i < N; i++) id[i] = i;
        height = new int[N];
        for(int i = 0;i < N; i++) height[i] = 0;
    }

    public int count(){
        return count;
    }

    private int find(int p){
        while(p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i == j) return;

        if(height[i] < height[j]){id[i] = j;}
        else if(height[i] > height[j]){id[j] = i;}
        else {
            id[j] = i;
            height[i]++;
        }
        count--;
    }
}
