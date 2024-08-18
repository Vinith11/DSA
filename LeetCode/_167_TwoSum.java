
public class _167_TwoSum {

    /*
     * Two pointer approach
     * 
     * Steps:
     * 1. Initialize two pointers, left and right, to point to the start and end of the array
     * 2. While the left pointer is less than the right pointer, do the following:
     * 3. Calculate the sum of the elements at the left and right pointers
     * 4. If the sum is equal to the target, return the indices of the elements
     * 5. If the sum is greater than the target, move the right pointer to the left
     * 6. If the sum is less than the target, move the left pointer to the right
     * 7. If the loop completes, return [-1, -1]
     * 
     * Time complexity: O(n)
     */
    public static int[] method1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = method1(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
