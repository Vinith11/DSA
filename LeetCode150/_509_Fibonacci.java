
public class _509_Fibonacci {

    public static int method1(int n) {
        if (n <= 1) {
            return n;
        }

        return method1(n - 1) + method1(n - 2);
    }


    /*
     * Tabulation
     * 
     * 1. We use bottom up approach to solve the problem
     * 2. Create a dp array of size n+1
     * 3. Initialize dp[0] = 0, dp[1] = 1 they are default values   
     * 4. Iterate from 2 to n and calculate dp[i] = dp[i-1] + dp[i-2]
     * 5. Return dp[n]
     * 
     * Time complexity: O(n)
     */
    public static int method2(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

        System.out.println(method1(4));
    }
}
