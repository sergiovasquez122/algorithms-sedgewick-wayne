import edu.princeton.cs.algs4.StdOut;

public class RandomGrid {
    private static class Connection {
        int p;
        int q;
        public Connection(int p, int q){
            this.p = p;
            this.q = q;
        }
    }

    public static RandomizedQueue<Connection> generate(int N){
        RandomizedQueue<Connection> queue = new RandomizedQueue<>();
        for(int i = 0;i < N;++i){
            for(int j = i + 1;j < N;++j){
                queue.enqueue(new Connection(i, j));
                queue.enqueue(new Connection(j, i));
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        RandomizedQueue<Connection> Q = generate(N);
        for(Connection c : Q){
            StdOut.println(c.p + " " + c.q);
        }
    }
}
