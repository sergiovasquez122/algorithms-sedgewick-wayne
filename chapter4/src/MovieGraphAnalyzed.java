import edu.princeton.cs.algs4.StdOut;

public class MovieGraphAnalyzed {

    public static void main(String[] args) {
        String filename = args[0];
        String delimeter = args[1];

        SymbolGraph SG = new SymbolGraph(filename, delimeter);
        Graph G = SG.G();
        CC cc = new CC(G);
        StdOut.println(cc.count());
    }
}
