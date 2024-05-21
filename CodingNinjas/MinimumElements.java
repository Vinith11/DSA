
import java.util.Arrays;

public class MinimumElements {

    /*
     * Recursive Method
     * 
     * Steps:
     * 1. We will check if the amount is 0, then we will return -1.
     * 2. We will call the solve method with the coins array and the amount.
     * 
     * 3. In the solve method, we will check if the amount is 0, then we will return 0.
     * 4. If the amount is less than 0, then we will return Integer.MAX_VALUE. because we here are finding min value
     *     suppose we only hit return; then we cannot find min number of coin to make the amount, check the for loop you'll get it\
     * 5. We will iterate over the coins array and call the solve method with the amount-coins[i].
     * 6. If the ans is not equal to Integer.MAX_VALUE, then we will find the minimum of the ans and the current minimum.
     *       Note 1 + ans in mini = Math.min(mini, 1 + ans); indicates numbber of coin used 
     *       Suppose there is an coin=[1,2,5] and amount is 5
     *       Then when recussion solve1(coins, 5 - 5); will return 0
     *       If we don't add 1 then the would look like Math.min(mini, 0 ); Which is wrong
     *       As we have used 1 coin to meet the target
     *       So we add 1 to the ans
     * 
     * Time Complexity: O(n^m)
     * Space Complexity: O(1)
     */
    public static int method1(int[] coins, int amount) {
        int n = coins.length;
        if (n == 0) {
            return -1;
        }
        return solve1(coins, amount);
    }

    public static int solve1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = solve1(coins, amount - coins[i]);
            if (ans != Integer.MAX_VALUE) {
                mini = Math.min(mini, 1 + ans);
            }
        }

        return mini;
    }

    /*
     * Recursive + Memoization Method
     * 
     * Steps:
     * 1. We will create a dp array of size amount+1 and fill it with -1.
     * 2. We will call a recursive function solve2(coins, amount, dp) which will return the minimum number of coins required to make the amount.
     * 
     * 3. In the solve2 method, we will check if the amount is 0, then we will return 0.
     * 4. If the amount is less than 0, then we will return Integer.MAX_VALUE.
     * 5. If dp[amount] is not equal to -1, then we will return dp[amount] if it is already calculated.
     * 6. We will iterate over the coins array and call the solve2 method with the amount-coins[i].
     * 7. If the ans is not equal to Integer.MAX_VALUE, then we will find the minimum of the ans and the current minimum.
     * 8. We will store the minimum in dp[amount] and return the minimum.
     * 
     * Time Complexity: O(n*m)
     * Space Complexity: O(n)
     */
    public static int method2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int ans = solve2(coins, amount, dp);
        if (ans == Integer.MAX_VALUE){ 
            return -1;
        } else {
            return ans;

        }
    }

    public static int solve2(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[amount] != -1) {
            return dp[amount];
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = solve2(coins, amount - coins[i], dp);
            if (ans != Integer.MAX_VALUE) {
                mini = Math.min(mini, 1 + ans);
            }
        }
        dp[amount] = mini;

        return mini;
    }

    /*
     * Bottom Up DP Method (Tabulation)
     * 
     * Steps:
     * 1. We will create a dp array of size amount+1, we will fill the array with INT_MAX and dp[0] = 0 as it is the base case.
     * 2. We will iterate from 1 to amount and fill the dp array with the minimum number of coins required to make the amount., this for loop will find minimum number of coins required to make the i 
     * 3. We will iterate over the coins array and check if the current coin is less than or equal to the amount, then we will find the minimum of the current minimum and 1+dp[i-coins[j]].
     * 4. We will return dp[amount] if it is not equal to INT_MAX, else we will return -1.
     * 
     * Time Complexity: O(n*m)
     * Space Complexity: O(n)
     */
    public static int method3(int[] coins, int amount) {
        return solve3(coins, amount);
    }
    public static int solve3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<=amount; i++){
            for (int j = 0; j < coins.length; j++) {

                if (i-coins[j]>=0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1+ dp[i - coins[j]]);
                }
            }
        }

        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        } else {
            return dp[amount];
        }
    }



    public static void main(String[] args) {
        // https://www.naukri.com/code360/problems/minimum-elements_3843091?leftPanelTab=0
        int[] coins = {1, 2, 3};
        int amount = 7;
        System.out.println(method3(coins, amount));
    }
}
