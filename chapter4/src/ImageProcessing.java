import edu.princeton.cs.algs4.StdOut;

public class ImageProcessing {

    // note this implementation assumes a image of 0's and 1's
    public ImageProcessing(boolean[][] image, int x, int y){
        boolean sourceColor = image[x][y];
        dfs(image, x, y, sourceColor);
    }

    private void dfs(boolean[][] image, int x, int y, boolean color){
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != color){
            return;
        }
        image[x][y] = !color;
        int[][] positions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] pos : positions){
            dfs(image, x + pos[0], y + pos[1], color);
        }
    }

    public static void main(String[] args) {
        boolean [][] image = {{false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}};
        ImageProcessing imageProcessing = new ImageProcessing(image, 0, 0);
        for(int i = 0;i < image.length;++i){
            for(int j = 0;j < image.length;++j){
                StdOut.print(image[i][j] + " ");
            }
            StdOut.println();
        }
        StdOut.println();
        boolean[][] image2 = {{true, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}};

        imageProcessing = new ImageProcessing(image2, 0, 0);
        for(int i = 0;i < image2.length;++i){
            for(int j = 0;j < image2.length;++j){
                StdOut.print(image2[i][j] + " ");
            }
            StdOut.println();
        }
    }
}
