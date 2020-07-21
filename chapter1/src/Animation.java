import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Animation {

    private class SiteLocation{
        double x;
        double y;

        SiteLocation(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    private void drawSites(int N){
        int cols = (int) Math.ceil(Math.sqrt(N));
    }

    public static void main(String[] args) {
        int N = 10;
        WeightedQuickUnionUF UF = new WeightedQuickUnionUF(N);
        StdDraw.setCanvasSize(500,500);
        StdDraw.setXscale(-1,N);
        StdDraw.setYscale(-0.5, N/2 + 1);
        StdDraw.setPenRadius(0.015);
        for(RandomGrid.Connection c : RandomGrid.generate(N)){
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(c.p, c.q);
        }
    }
}
