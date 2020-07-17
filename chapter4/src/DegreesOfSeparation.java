import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DegreesOfSeparation {
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();

        String source = args[2];
        if(!sg.contains(source)){
            StdOut.println(source + " not in database.");
            return;
        }

        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

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
/*
Phoenix, Joaquin
 Bacon, Kevin
 Woodsman, The (2004)
 Majors, Paul
 Ladder 49 (2004)
 Phoenix, Joaquin
Pryce, Jonathan
 Bacon, Kevin
 Where the Truth Lies (2005)
 Firth, Colin
 What a Girl Wants (2003)
 Pryce, Jonathan
Driver, Adam
Not in database.
Banderas, Antonio
Not in database.
DiCaprio, Leonardo
 Bacon, Kevin
 Trapped (2002)
 Theron, Charlize
 Celebrity (1998)
 DiCaprio, Leonardo
Erivo, Cynthia
Not in database.
Johansson, Scarlett
 Bacon, Kevin
 Where the Truth Lies (2005)
 Bennett, Sonja
 Perfect Score, The (2004)
 Johansson, Scarlett
Ronan, Saoirse
Not in database.
Theron, Charlize
 Bacon, Kevin
 Trapped (2002)
 Theron, Charlize
Zellweger, Renee
Not in database.
 */
