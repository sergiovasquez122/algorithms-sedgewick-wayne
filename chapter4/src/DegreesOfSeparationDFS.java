import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// note may be required to increase your system stack size if you
// try to run this program because of the recursion in dfs
public class DegreesOfSeparationDFS {
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();

        String source = args[2];
        if(!sg.contains(source)){
            StdOut.println(source + " not in database.");
            return;
        }

        int s = sg.index(source);
        DepthFirstPaths bfs = new DepthFirstPaths(G, s);

        while(!StdIn.isEmpty()){
            String sink = StdIn.readLine();
            if(sg.contains(sink)){
                int t = sg.index(sink);
                if(bfs.hasPathTo(t))
                    for(int v : bfs.pathTo(t))
                        StdOut.println(" " + sg.name(v));
                else StdOut.println("Not connected");
            } else StdOut.println("Not in database.");
        }
    }
}
