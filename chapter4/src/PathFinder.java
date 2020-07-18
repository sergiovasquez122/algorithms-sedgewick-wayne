import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Stack;

public class PathFinder {

    private ST<String, Integer> dist;
    private ST<String, String> parent;

    public PathFinder(OnePassSymbolGraph G, String s){
        parent = new ST<>();
        dist = new ST<>();
        Queue<String> queue = new Queue<>();
        queue.enqueue(s);
        dist.put(s, 0);
        while(!queue.isEmpty()){
            String curr = queue.dequeue();

            for(String w : G.adjTo(curr)){
                if(!dist.contains(w)){
                    parent.put(w, curr);
                    dist.put(w, dist.get(curr) + 1);
                    queue.enqueue(w);
                }
            }
        }
    }

    public int distanceTo(String v){
        return dist.get(v);
    }

    public boolean hasPathTo(String v){
        return parent.contains(v);
    }

    public Iterable<String> pathTo(String v){
        Stack<String> path = new Stack<>();
        while(v != null && dist.contains(v)){
            path.push(v);
            v = parent.get(v);
        }
        return path;
    }
}
