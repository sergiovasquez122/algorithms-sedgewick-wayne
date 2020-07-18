public class MovieGraphAnalyzed {

    public static void main(String[] args) {
        String filename = args[0];
        String delimeter = args[1];
        String source = args[2];

        SymbolGraph SG = new SymbolGraph(filename, delimeter);
    }
}
