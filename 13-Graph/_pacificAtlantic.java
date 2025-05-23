import java.util.*;

public class _pacificAtlantic {

    private static void dfs(int[][] heights, boolean[][] ocean, int row, int col, int rows, int cols){
        ocean[row][col] = true;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int[] direction: directions){
            int newRow = row+ direction[0];
            int newCol = col+ direction[1];
            if(newRow >=0 && newRow < rows && newCol>=0 && newCol<cols && !ocean[newRow][newCol] && heights[newRow][newCol]>= heights[row][col]){
                dfs(heights, ocean, newRow, newCol, rows, cols);
            }
        }
    }
    
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            dfs(heights, pacific, i, 0, n, m);
            dfs(heights, atlantic, i, m-1, n, m);
        }

        for(int i=0; i<m; i++){
            dfs(heights, pacific, 0, i, n, m);
            dfs(heights, atlantic, n-1, i, n, m);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights));   
    }
}
