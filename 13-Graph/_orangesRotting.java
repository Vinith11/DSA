
import java.util.LinkedList;
import java.util.Queue;

public class _orangesRotting{

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    fresh++;
                } else if(grid[i][j]==2){
                    q.offer(new int[] {i, j});
                }
            }
        }

        int[][] directions = {{-1, 0}, {1,0}, {0,1}, {0,-1}};

        while(!q.isEmpty() && fresh>0){

            for(int i=0; i<q.size(); i++){
                int[] temp = q.poll();
                int r = temp[0];
                int c = temp[1];

                for(int[] direction : directions){
                    int dr = r + direction[0];
                    int dc = c + direction[1];
                    if(dr<0 || dc<0 || dr>=rows || dc>=cols || grid[dr][dc] !=1){
                        continue;
                    }
                    grid[dr][dc] = 2;
                    q.offer(new int[] {dr, dc});
                    fresh-=1;
                }
            }
            time++;
        }
        

        return fresh == 0 ? time : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println(orangesRotting(grid));
    }
}