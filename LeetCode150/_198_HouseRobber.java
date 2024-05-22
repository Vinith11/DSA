
import java.util.Arrays;

public class _198_HouseRobber {

    /*
     * Recursion
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    public static int method1(int[] arr) {
        return solve1(arr, arr.length - 1);
    }

    public static int solve1(int[] arr, int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return arr[0];
        }
        int incl = solve1(arr, n - 2) + arr[n];
        int excl = solve1(arr, n - 1) + 0;
        return Math.max(incl, excl);
    }

    /*
     * Recursive + Memoization Method
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)+O(n) = O(n)
     */
    public static int method2(int[] arr) {
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return solve2(arr, arr.length - 1, dp);
    }

    public static int solve2(int[] arr, int n, int[] dp) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return arr[0];
        }

        if (dp[n] != -1) {
            return dp[n];
        }
        int incl = solve2(arr, n - 2, dp) + arr[n];
        int excl = solve2(arr, n - 1, dp) + 0;
        int ans = Math.max(incl, excl);
        dp[n] = ans;

        return ans;
    }


    /*
     * Tablulation
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int method3(int[] arr) {
        return solve3(arr);
    }

    public static int solve3(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = arr[0];

        for(int i =1; i<n; i++){
            dp[i+1] = Math.max(dp[i], dp[i-1] + arr[i]);
        }

        return dp[n];
    }

    /*
     * Space Optimized 
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int method4(int[] arr) {
        return solve4(arr);
    }

    public static int solve4(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        int prev1 = 0;
        int prev2 = 0;

        for(int i =0; i<n; i++){
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + arr[i]);
            prev2 = temp;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(method4(arr));
    }
}
