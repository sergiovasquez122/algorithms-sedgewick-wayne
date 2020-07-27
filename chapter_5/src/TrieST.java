import edu.princeton.cs.algs4.Queue;

public class TrieST<Value> {
    private static int R = 256;
    private Node root;

    private static class Node{
        private Object val;
        private Node[] next = new Node[R];
    }

    public Value get(String key){
        Node x = get(root, key, 0);
        if(x == null) return null;
        return (Value) x.val;
    }

    private void collect(Node x, String pre, Queue<String> q){
        if(x == null) return;
        if(x.val != null) q.enqueue(pre);
        for(char c = 0;c < R;c++)
            collect(x.next[c], pre + c, q);
    }


    private Node get(Node x, String key, int d){
        if(x == null) return null;
        if(d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value val){
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key,Value val, int d){
        if(x == null) x = new Node();
        if(d == key.length()){x.val = val; return x;}
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }
}
