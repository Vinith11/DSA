public class _maxSubArray {

    /*
     * Brute Force
     */
    public static int maxSubArray1(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                ans = Math.max(currSum, ans);
            }
        }
        return ans;
    }

    /*
     * Kadane's Algorithm
     * 
     * 1. Kadane's Algorithm goes on adding the value of array in sum
     * 2. If the sum is greater than the maxTillNow then maxTillNow is updated
     * 3. If the sum is less than 0 then sum is set to 0
     */
    public static int maxSubArray2(int[] nums) {
        int sum = 0;
        int maxTillNow = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > maxTillNow) {
                maxTillNow = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return maxTillNow;
    }

    /*
     * Divide and Conquer
     */
    public static int maxSubArray3(int[] nums) {
        return 0;
    }

    /*
     * Follow up question to print the subarray
     */
    public static int printSubArray(int[] nums) {
        int sum = 0;
        int maxTillNow = Integer.MIN_VALUE;
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i < nums.length; i++) {
            // sum = 0 indicates new subarray start if sum becomes negative
            if (sum == 0) {
                start = i;
            }

            sum += nums[i];

            if (sum > maxTillNow) {
                maxTillNow = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        // printing the subarray:
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("]\n");

        return maxTillNow;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // System.out.println(maxSubArray2(arr));
        System.out.println(printSubArray(arr));
    }
}
