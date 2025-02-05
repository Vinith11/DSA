import java.util.*;

public class _climbStairs {
    
    // recursion
    public int climbStairs1(int n) {
        if(n==0 || n==1){
            return 1;
        }

        return climbStairs1(n-1) + climbStairs1(n-2);
    }

    //memoization
    public int climbStairs2(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climb(n,memo);
    }

    private int climb(int n,Map<Integer, Integer> memo){
        if(n==1 || n==0){
            return 1;
        }
        if(!memo.containsKey(n)){
            memo.put(n, climb(n-1, memo)+ climb(n-2, memo));
        }

        return memo.get(n);
    }

    //tablulation
    public int climbStairs3(int n) {
        if(n==0 || n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
