
import java.util.Arrays;

public class _746_MinCostClimb{

    /*
     * Recusion Method
     * 
     * Steps:
     * 1. At each step, we have two choices, either we can take 1 step or 2 steps.
     * 2. If we take 1 step, then we can move to the next step and the cost will be cost[i] + solve(cost, i+1)
     * 3. If we take 2 steps, then we can move to the next step and the cost will be cost[i] + solve(cost, i+2)
     * 4. We will take the minimum of the two choices.
     * 5. Base case: If we are at the last step, then we will return 0 or 1.
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    public static int method1(int[] cost) {
        int n = cost.length;
        int ans = Math.min(solve(cost,n-1),solve(cost,n-2));
        return ans;
    }
    public static int solve(int[] cost, int n){
        if(n==0||n==1){
            return cost[n];
        }
        int ans = cost[n] + Math.min(solve(cost,n-1),solve(cost,n-2));
        return ans;
    }


    /*
     * Top Down DP Method (Recursion + Memoization)
     * 
     * Steps:
     * 1. We will create a dp array of size n and fill it with -1.
     * 2. We will call a recursive function solve2(cost, n, dp) which will return the minimum cost for n-1 and n-2
     * 3.  in Solve method we will check if n==0 or n==1, then we will return cost[n]
     * 4. If dp[n]!=-1, then we will return dp[n] if it is already calculated.
     * 5. We will calculate the cost for n-1 and n-2 and store it in dp[n].
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     */
    public static int method2(int[] cost){
        int n=cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return Math.min(solve2(cost,n-1,dp),solve2(cost,n-2,dp));
    }
    public static int solve2(int[] cost, int n, int[] dp){
        if(n==0||n==1){
            return cost[n];
        }
        if(dp[n]!=-1){
            return dp[n];
        }

        dp[n] = cost[n] + Math.min(solve2(cost,n-1,dp),solve2(cost,n-2,dp));
        return dp[n];
    }

    /*
     * Bottom Up DP Method (Tabulation)
     * 
     * Steps:
     * 1. We will create a dp array of size n, and before we start tabulaisation method we will check if n==0 or n==1, then we will return cost[n]
     * 2. We will fill the dp array with the base cases. in solve method
     * 3. We will iterate from 2 to n and fill the dp array with the minimum cost.
     * 4. The minimum cost will be the minimum of dp[n-1] and dp[n-2]
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int method3(int[] cost){
        int n =cost.length;
        if(n==0 || n==1){
            return cost[n];
        }
        int[] dp = new int[n];
        return solve3(cost,dp,n);
    }
    public static int solve3(int[] cost, int[] dp, int n){
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++){
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }

    /*
     * Space Optimisation
     * 
     * Steps:
     * 1. We will create two variables a and b and assign the first two elements of the cost array to them.
     * 2. We will iterate from 2 to n and calculate the minimum cost.
     * 3. The minimum cost will be the minimum of a and b.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int method4(int[] cost){
        int n =cost.length;
        if(n==0 || n==1){
            return cost[n];
        }
        int a = cost[0];
        int b = cost[1];
        for(int i=2;i<n;i++){
            int c = cost[i] + Math.min(a,b);
            a=b;
            b=c;
        }

        return Math.min(a,b);
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(method4(cost));
    }
}