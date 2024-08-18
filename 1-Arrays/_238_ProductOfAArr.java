
import java.util.Arrays;


public class _238_ProductOfAArr {

    /*
     * Brute Force Approach
     * 
     * Time Complexity: O(n^2)
     */
    public static int[] method1(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int pro = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    pro *= arr[j];
                }
            }
            ans[i] = pro;
        }

        return ans;
    }

    /*
     * Dividing the product of array with the number
     * 
     * Time Complexity: O(n)
     */
    public static int[] method2(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int pro = 1;

        for (int i : arr) {
            pro *= i;
        }

        for (int i = 0; i < n; i++) {
            ans[i] = pro / arr[i];
        }

        return ans;
    }

    /*
     * Finding Prefix Product and Suffix Product
     * 
     * Steps
     * 
     * 1. create two arrays pre and suff of size n, pre[0] = 1, suff[n-1] = 1
     * 2. fill the pre array with the product of all the elements before the current element: pre[i] = pre[i - 1] * arr[i - 1]; 
     * 3. fill the suff array with the product of all the elements after the current element: suff[i] = suff[i + 1] * arr[i + 1];
     * 4. create a new array ans of size n, and fill it with the product of pre[i] and suff[i]: ans[i] = pre[i] * suff[i];
     * 5. return the ans array
     * 
     * Time Complexity: O(n)
     */

    public static int[] method3(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n];
        int[] suff = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * arr[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * arr[i + 1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }

        return ans;

    }


    /*
     *  Directly store the product of prefix and suffix into the final answer array
     * 
     * Steps:
     * 1. create an array ans of size n, and fill it with 1
     * 2. create a variable curr which stores curernt value and initialize it with 1
     * 3. iterate over the array from left to right 
     *          - multiply the current element with curr and store it in ans[i]
     *          - multiply curr with the nums(input array) element and store in curr
     * 4. reset the curr to 1
     * 5. iterate over the array from right to left 
     *          - multiply the current element with curr and store it in ans[i]
     *          - multiply curr with the nums(input array) element and store in curr
     * 6. return the ans array
     * 
     * 
     * Time Complexity: O(n)
     */

    public static int[] method4(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int curr = 1;
        for (int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] result = method4(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
