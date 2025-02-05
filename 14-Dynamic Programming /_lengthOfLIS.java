import java.util.Arrays;
import java.util.Collections;

public class _lengthOfLIS {
    //recursion
    public int lengthOfLIS1(int[] nums) {
        return recur(-1, 0, nums);
    }

    private int recur(int prev, int curr, int[] nums){
        if(curr==nums.length){
            return 0;
        }

        int first = 0;
        if(prev == -1 || nums[prev]<nums[curr]){
            first = 1 + recur(curr, curr+1, nums);
        }
        int sec = recur(prev, curr+1, nums);
        return Math.max(first, sec);
    }

    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i=nums.length -1; i>=0; i--){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]<nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

}
