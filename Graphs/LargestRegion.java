import java.io.*;

public class LargestRegion {

    int[][] matrix;
    int max = -1;
    int count;
    int m, n;
    int dx[] = { 0, 1, 0, -1, -1, 1, 1, -1 };
    int dy[] = { 1, 0, -1, 0, -1, 1, -1, 1 };
    boolean[][] visited;

    public static void main(String args[]) {
        int[][] matrix = { { 0, 0, 1, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1 } };
        LargestRegion largestRegion = new LargestRegion();
        largestRegion.matrix = matrix;
        largestRegion.find();
        System.out.println(largestRegion.max);
    }

    private void find() {
        m = matrix.length;
        n = matrix[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    if (max < count) {
                        max = count;
                    }
                }
            }
        }
    }

    private void dfs(int i, int j) {
        visited[i][j] = true;
        ++count;
        for (int index = 0; index < 8; index++) {
            int x = i + dx[index];
            int y = j + dy[index];
            if (boundary(x, y) && !visited[x][y]) {
                dfs(x, y);
            }
        }
    }

    private boolean boundary(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }
        if (matrix[i][j] != 1) {
            return false;
        }
        return true;
    }

}
