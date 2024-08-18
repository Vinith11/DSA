public class _70_Climbstairs{


    /*
     * Recurssive solution
     * 
     * Base Case : n=0, return 1
     *             n<0, return 0
     * 
     * Recursive relation: f(n) = f(n-1) + f(n-2)
     * 
     * Time complexity: O(2^n)
     */
    public static int method1(int n) {
        if(n<0){
            return 0;
        }

        if(n==0){
            return 1;
        }

        return method1(n-1) + method1(n-2);
    }


    /*
     * Tabulation
     * 
     * Base Case : n=0, return 1
     *            n<0, return 0
     * 
     * 1. We use bottom up approach to solve the problem
     * 2. Create a dp array of size n+1
     * 3. Initialize dp[0] = 1, dp[1] = 1 they are the base cases as to reach step 0 and 1 there is only one way
     * 4. Iterate from 2 to n and calculate dp[i] = dp[i-1] + dp[i-2]
     * 5. Return dp[n]
     * 
     * Time complexity: O(n)
     */
    public static int method2(int n) {
        if(n<=1){
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i =2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(method2(5));
    
    }
}