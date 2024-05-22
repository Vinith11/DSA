
import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumNonAdju {

    /*
     * Recursive Method
     * 
     * Steps:
     * 1. We will call a recursive function solve1(arr, n) which will return the maximum sum of non-adjacent elements.
     * 
     * 2. In the solve1 method, we will check if n is less than 0, then we will return 0.
     * 3. If n is equal to 0, then we will return arr[0].
     * 4. From question we know we cannot take the adjucant elements so we either inculde current element or exclude current element and incriment by 1
     *      lets say n = n - 1 i.e 2
     *      incl = solve1(arr, n-2) + arr[n] => solve1(arr, 0) + arr[2] => arr[0] + arr[2] => 1 + 4 => 5 this is what it looks if we inculde the current element
     *      excl = solve1(arr, n-1) + 0 => solve1(arr, 1) + 0 => arr[1] + 0 => 2 + 0 => 2 this is what it looks if we exclude the current element
     * 5. We will return the maximum of incl and excl.
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(n) 
     */
    public static int method1(int[] arr) {
        int n = arr.length;
        return solve1(arr, n - 1);
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
    public static int method2(ArrayList<Integer> arr) {
        int n = arr.size();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        return solve2(arr, n - 1, dp);
    }

    public static int solve2(ArrayList<Integer> arr, int n, int[] dp) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return arr.get(0);
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int incl = solve2(arr, n - 2, dp) + arr.get(n);
        int excl = solve2(arr, n - 1, dp) + 0;
        dp[n] = Math.max(incl, excl);
        return dp[n];
    }


    /*
     * Tablulation
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int method3(ArrayList<Integer> arr) {
        int n = arr.size();
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr.get(0);
        }

        int[] dp = new int[n];
        dp[0] = arr.get(0);
        dp[1] = Math.max(arr.get(0), arr.get(1)); // Initialize dp[1] properly

        for (int i = 2; i < n; i++) {
            int incl = dp[i - 2] + arr.get(i);
            int excl = dp[i - 1];

            dp[i] = Math.max(incl, excl);
        }

        return dp[n - 1];
    }

    public static int method4(ArrayList<Integer> arr) {
        int n = arr.size();
        int prev2=0;
        int prev1=arr.get(0);


        for (int i = 2; i < n; i++) {
            int incl = prev2 + arr.get(i);
            int excl = prev1;

            int ans = Math.max(incl, excl);
            prev2 = prev1;
            prev1 = ans;
        }

        return prev1;
    }

    public static void main(String[] args) {
        // https://www.naukri.com/code360/problems/maximum-sum-of-non-adjacent-elements_843261?leftPanelTab=0&leftPanelTabValue=SUBMISSION
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(4);
        System.out.println(method3(arr));
    }
}
