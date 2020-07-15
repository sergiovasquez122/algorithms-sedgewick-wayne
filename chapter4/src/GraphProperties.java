import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class GraphProperties {
    private int[] eccentricity;
    private int diameter = Integer.MIN_VALUE;
    private int radius = Integer.MAX_VALUE;
    private int center;
    private int girth = Integer.MAX_VALUE;

    GraphProperties(Graph G){
        BreadthFirstPaths[] bfs = new BreadthFirstPaths[G.V()];
        eccentricity = new int[G.V()];
        for(int i = 0;i < G.V();++i){
            bfs[i] = new BreadthFirstPaths(G, i);
            int max_of_i = Integer.MIN_VALUE;
            for(int k = 0;k < G.V();++k){
                max_of_i = Math.max(max_of_i, bfs[i].distTo(k));
            }
            eccentricity[i] = max_of_i;
            diameter = Math.max(diameter, eccentricity[i]);
            radius = Math.min(radius, eccentricity[i]);
            if(radius == eccentricity[i]){
                center = i;
            }
        }

        for(int i = 0;i < G.V();++i){
            computeGirth(G, i);
        }
    }

    private void computeGirth(Graph G, int s){
        boolean marked[] = new boolean[G.V()];
        int distTo[] = new int[G.V()];
        int edgeTo[] = new int[G.V()];
        marked[s] = true;
        Queue<Integer> frontier = new Queue<>();
        frontier.enqueue(s);
        while(!frontier.isEmpty()){
            int v = frontier.dequeue();
            for(int w : G.adj(v)){
                if(!marked[w]){
                    distTo[w] = distTo[v] + 1;
                    edgeTo[w] = v;
                    marked[w] = true;
                    frontier.enqueue(w);
                } else if(edgeTo[v] != w){
                    girth = Math.min(girth, distTo[v] + distTo[w] + 1);
                }
            }
        }
    }

    int eccentricity(int v){
        return eccentricity[v];
    }

    int diameter(){
        return diameter;
    }

    int radius(){
        return radius;
    }

    int center(){
        return center;
    }

    int girth(){
        return girth;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(11);
        graph.addEdge(0 ,1);
        graph.addEdge(1 ,2);
        graph.addEdge(2 ,3);
        graph.addEdge(3 ,4);
        graph.addEdge(4 ,5);
        graph.addEdge(5 ,6);
        graph.addEdge(6 ,7);
        graph.addEdge(7 ,8);
        graph.addEdge(8 ,9);
        graph.addEdge(9 ,10);

        GraphProperties graphProperties = new GraphProperties(graph);
        StdOut.println("Diameter: " + graphProperties.diameter() + " Expected: 10");
        StdOut.println("Radius: " + graphProperties.radius() + " Expected: 5");
        StdOut.println("Center: " + graphProperties.center() + " Expected: 5");

        Graph graph1 = new Graph(6);
        graph1.addEdge(2 ,3);
        graph1.addEdge(0 ,1);
        graph1.addEdge(3 ,1);
        graph1.addEdge(5 ,3);
        graph1.addEdge(2 ,0);
        graph1.addEdge(1 ,2);
        graph1.addEdge(4 ,2);
        graph1.addEdge(4 ,5);
        graph1.addEdge(4 ,0);

        // Graph with girth = 2
        Graph graph2 = new Graph(4);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 0); //Parallel edge
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);

        // Graph with girth = 4
        Graph graph3 = new Graph(4);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);
        graph3.addEdge(2, 3);
        graph3.addEdge(3, 0);

        // Graph with girth = Integer.MAX_VALUE
        Graph graph4 = new Graph(4);
        graph4.addEdge(0, 1);
        graph4.addEdge(1, 3);
        graph4.addEdge(2, 3);

        GraphProperties graphProperties1 = new GraphProperties(graph1);
        StdOut.println("Girth 1: " + graphProperties1.girth() + " Expected: 3");

        GraphProperties graphProperties2 = new GraphProperties(graph2);
        StdOut.println("Girth 2: " + graphProperties2.girth() + " Expected: 2");

        GraphProperties graphProperties3 = new GraphProperties(graph3);
        StdOut.println("Girth 3: " + graphProperties3.girth() + " Expected: 4");

        GraphProperties graphProperties4 = new GraphProperties(graph4);
        StdOut.println("Girth 4: " + graphProperties4.girth() + " Expected: 2147483647");
    }
}
