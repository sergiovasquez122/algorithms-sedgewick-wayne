import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class ErdosRenyiModel {
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
        int Trials = Integer.parseInt(args[1]);
        int[] edges = new int[Trials];

        for(int t = 0;t < Trials;++t)
            edges[t] = count(N);
        StdOut.println("1/2*n*lnn = " + 0.5 * N * Math.log(N));
        StdOut.println("Mean = " + StdStats.mean(edges));
        StdOut.println("Stddev = " + StdStats.stddev(edges));
    }
}
