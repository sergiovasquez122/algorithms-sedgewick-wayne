public class AVLTreeST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node{
        private Node left;
        private Node right;
        private final Key key;
        private Value val;
        private int size;
        private int height;

        public Node(Key key, Value val, int size, int height){
            this.key = key;
            this.val = val;
            this.size = size;
            this.height = height;
        }
    }

    public Value get(Key key){
        return get(root, key).val;
    }

    private Node get(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return get(x.left, key);
        else if(cmp > 0) return get(x.right, key);
        else return x;
    }

    private Node insert(Node x, Key key, Value val){
        if(x == null) return new Node(key,val, 1, -1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = insert(x.left, key, val);
        else if(cmp > 0) x.right = insert(x.right, key, val);
        else x.val = val;
        x.size = size(x.left) + size(x.right) + 1;
        x.height = 1 + Integer.max(height(x.left), height(x.right));
        return x;
    }

    public int height(){
        return height(root);
    }

    private int height(Node x){
        if(x == null) return 0;
        else return x.height;
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null) return 0;
        else return x.size;
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left != null) return min(x.left);
        else return x;
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node x){
        if(x.right != null) return max(x.right);
        else return x;
    }

    public boolean isEmpty(){
        return root == null;
    }
}
