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
}
