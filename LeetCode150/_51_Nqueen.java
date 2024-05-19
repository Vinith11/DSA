
import java.util.ArrayList;
import java.util.List;


public class _51_Nqueen {

    public boolean isSafe(int row,int col,int grid[][],int n){
        for(int i=0;i<col;i++){
            if(grid[row][i]==1) return false;
        }
       
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(grid[i][j]==1){
                return false;
            }
        }
        for(int i=row+1,j=col-1;i<n&&j>=0;i++,j--){
            if(grid[i][j]==1){
                return false;
            }
        }
        return true;
    }
    public boolean solve(int col,int n,int grid[][],List<List<String>> ans){
        if(col==n){
            List<String> ar=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder str=new StringBuilder("");
                for(int j=0;j<n;j++){
                    if(grid[i][j]==1)str.append("Q");
                    else str.append(".");

                }
                ar.add(new String(str));
            }
            ans.add(new ArrayList<String>(ar));
            return false;
        }
        for(int i=0;i<n;i++){
            if(isSafe(i,col,grid,n)){
                grid[i][col]=1;
                if(solve(col+1,n,grid,ans)){
                    return true;
                }
                grid[i][col]=0;
            }
        }
        return false;

    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        int grid[][]=new int[n][n];
        solve(0,n,grid,ans);
        return ans;
    }

    public static void main(String[] args) {
        _51_Nqueen nq=new _51_Nqueen();
        List<List<String>> ans=nq.solveNQueens(4);
        for(List<String> ar:ans){
            for(String str:ar){
                System.out.println(str);
            }
            System.out.println();
        }
    }
}
