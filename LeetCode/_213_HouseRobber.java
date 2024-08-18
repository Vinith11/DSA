
import java.util.Arrays;


public class _213_HouseRobber {

    /*
     * Recursive Approach
     * 
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    public static int method1(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int case1 = solve1(nums, 0, n - 2);
        int case2 = solve1(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    public static int solve1(int[] nums, int index, int end) {
        if (index > end) {
            return 0;
        }

        if (index == end) {
            return nums[index];
        }

        int ans1 = nums[index] + solve1(nums, index + 2, end);

        int ans2 = solve1(nums, index + 1, end);

        return Math.max(ans1, ans2);
    }


    /*
     * Recursive Approach with Memoization
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) + O(n) = O(n)
     */
    public static int method2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp1 = new int[n+1];
        Arrays.fill(dp1, -1);
        int[] dp2 = new int[n+1];
        Arrays.fill(dp2, -1);

        int case1 = solve2(nums, 0, n - 2, dp1);
        int case2 = solve2(nums, 1, n - 1, dp2);

        return Math.max(case1, case2);
    }

    public static int solve2(int[] nums, int index, int end, int[] dp) {
        if (index > end) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int ans1 = nums[index] + solve2(nums, index + 2, end, dp);

        int ans2 = solve2(nums, index + 1, end, dp);

        dp[index] = Math.max(ans1, ans2);

        return dp[index];
    }

    /*
     * Tabulation
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int method3(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        dp2[0] = 0;
        dp2[1] = nums[1];

        int case1 = solve3(nums, 0, n - 2, dp1);
        int case2 = solve3(nums, 1, n - 1, dp2);

        return Math.max(case1, case2);
    }

    public static int solve3(int[] nums, int index, int end, int[] dp) {
        int n;
        if(end == nums.length - 1){
            n = nums.length;
        }else{
            n = nums.length - 1;
        }

        for(int i =2; i<n; i++){
            int ans1 = dp[i-2] + nums[i];
            int ans2 = dp[i-1];
            dp[i] = Math.max(ans1, ans2);
        }

        return dp[n-1];
    }

    /*
     * Space Optimized 
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int method4(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int case1 = solve4(nums, 0, n - 2);
        int case2 = solve4(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    public static int solve4(int[] nums, int index, int end) {
        int prev2=0;
        int prev1=nums[index];

        for(int i =index+1; i<end+1; i++){
            int rob = nums[i];
            if(i>index+1){
                rob += prev2;
            }
            int nonRob = prev1;

            int curr = Math.max(rob, nonRob);
            prev2 = prev1;
            prev1 = curr;
            
        }

        return prev1;
    }

    public static void main(String[] args) {
        /*
         * Note According to the problem, the first and last houses are connected. So, we can't rob both of them at the same time.
         * So, we can solve this problem by dividing it into two subproblems.
         * Case 1: we rob the first house and don't rob the last house. so we can rob from 0 to n-2 houses.
         * Case 2: we don't rob the first house and rob the last house. so we can rob from 1 to n-1 houses.
         */
        int[] nums = {1, 2, 3, 1};
        System.out.println(method4(nums));
    }
}
