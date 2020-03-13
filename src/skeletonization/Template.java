package skeletonization;

/**
 * Created by Dasha on 22.03.2015.
 */
public class Template {
    private int[][] array;

    public Template(int[][] array) {
        this.array = array;
    }
     public int get(int i, int j) {
         return array[i][j];
     }

    public Template rotate(int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = array[n - j - 1][i];
            }
        }
        return new Template(res);
    }

}
