
import java.util.Arrays;

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
     * Space complexity: O(n)
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

    /*
     * Memoization
     * 
     * 1. We use top down approach to solve the problem
     * 2. Create a dp array of size n+1 and fill it with -1
     * 3. Initialize dp[0] = 0, dp[1] = 1 they are default values   
     * 4. Check if dp[n] is not equal to -1 then return dp[n]
     * 5. If dp[n] is -1 then calculate dp[n] = fib(n-1) + fib(n-2)
     * 6. Return dp[n]
     * 
     * Time complexity: O(n)
     * Space complexity: O(n)+O(n) = O(n)
     */
    public static int method3(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        return fib(n, dp);
    }

        
    public static int fib(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    }

    /*
     * Space optimized
     * 
     * 1. We use top down approach to solve the problem
     * 2. Create two variables a = 0, b = 1
     * 3. Iterate from 2 to n and calculate a = a + b, b = a + b
     * 4. Return a
     * 
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int method4(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }



    public static void main(String[] args) {

        System.out.println(method4(2));
    }
}
