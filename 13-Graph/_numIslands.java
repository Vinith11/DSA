import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _numIslands {
    public static int numIslands(char[][] grid) {
        // ans
        int islands = 0;

        // note of size of matrix
        int rows = grid.length;
        int cols = grid[0].length;

        // visited Set
        Set<String> visited = new HashSet<>();

        // all directions that are allowed to travel
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited.contains(i + "," + j)) {
                    islands++;
                    bfs(grid, i, j, visited, directions, rows, cols);
                }
            }
        }

        return islands;
    }

    public static void bfs(char[][] grid, int r, int c, Set<String> visited, int[][] directions, int rows, int cols) {
        Queue<int[]> q = new LinkedList<>();
        visited.add(r + "," + c);

        // add the node in queue
        q.offer(new int[] { r, c });

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int row = temp[0], col = temp[1];

            // find all direactions N,S,W,E side that if it is visited or not
            for (int[] direction : directions) {
                int nr = row + direction[0];
                int nc = col + direction[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1'
                        && !visited.contains(nr + "," + nc)) {
                    q.offer(new int[] { nr, nc });
                    visited.add(nr + "," + nc);
                }
            }
        }
    }



    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        System.out.println(numIslands(grid));
    }
}
