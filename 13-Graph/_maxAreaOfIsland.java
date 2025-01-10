public class _maxAreaOfIsland {
    int[][] grid;
    int rows, cols;

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(i, j));
                }
            }
        }

        return ans;
    }

    private int dfs(int row, int col) {
        if (row >= rows || col >= cols || row < 0 || col < 0 || grid[row][col] == 0) {
            return 0;
        }

        // marking the 1 number as 0 assuming the the no. is seen and the code doesnt
        // reads it again
        grid[row][col] = 0;

        return 1 + dfs(row + 1, col) + dfs(row - 1, col) + dfs(row, col + 1) + dfs(row, col - 1);
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 1 }
        };

        System.out.println(new _maxAreaOfIsland().maxAreaOfIsland(grid));
    }
}