import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Calendar;

public class DegreeOfSeparationExpanded {
    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        String source = args[2];
        int y = Integer.parseInt(args[3]);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph G = sg.G();

        if(!sg.contains(source)){
            StdOut.println(source + " not in database.");
            return;
        }

        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        while(!StdIn.isEmpty()){
            String sink = StdIn.readLine();

            int movieYear = Integer.parseInt(sink.substring(sink.length() - 5, sink.length() - 1));
            if(currentYear - movieYear > y){
                StdOut.println("Ignoring movies more than " + y + " years old.");
                continue;
            }

            if(sg.contains(sink)){
                if(bfs.hasPathTo(sg.index(sink))){
                    for(int w : bfs.pathTo(sg.index(sink))){
                        StdOut.println(" " + sg.name(w));
                    }
                }
            } else{
                StdOut.println("Sink is not in the database");
            }
        }
    }
}
