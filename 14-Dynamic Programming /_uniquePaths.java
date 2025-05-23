import java.util.Arrays;

public class _uniquePaths {
    public static int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);

        for(int i=1; i<m; i++){
            int[] currRow = new int[n];
            Arrays.fill(currRow, 1);
            for(int j=1; j<n; j++){
                currRow[j] = currRow[j-1] + row[j];
            }
            row=currRow;
        }

        return row[n-1];
    }
    public static void main(String[] args) {
        int m=3;
        int n=7;
        System.out.println(uniquePaths(m, n));
    }
}