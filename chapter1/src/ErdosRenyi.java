import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class ErdosRenyi {

    public static int count(int N){
        WeightedQuickUnionUF UF = new WeightedQuickUnionUF(N);
        int count = 0;
        while(UF.count() > 1){
            int i = StdRandom.uniform(N);
            int j = StdRandom.uniform(N);
            UF.union(i, j);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int count = count(N);
        StdOut.println(count);
    }
}
