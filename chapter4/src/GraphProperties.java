import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.List;

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
    }
}
