import edu.princeton.cs.algs4.In;

public class TestClient {
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        System.out.println(G);
    }
}
