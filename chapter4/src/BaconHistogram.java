import edu.princeton.cs.algs4.StdOut;

public class BaconHistogram {
    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        String source = args[2];

        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph G = sg.G();
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, sg.index(source));
        int MAX = 100;
        int[] histogram = new int[MAX + 1];
        for(int v = 0;v < G.V(); v++) {
            if (bfs.hasPathTo(v)) {
                histogram[bfs.distTo(v)]++;
            } else {
                histogram[MAX]++;
            }
        }

        for(int i = 0;i < histogram.length ;i+=2){
            StdOut.println("Distance of " + i/2 + ": " + histogram[i]);
        }
    }
}
