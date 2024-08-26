public class _binarySearch {

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;

        if (l == h && nums[l] == target) {
            return l;
        }

        while (l <= h) {
            int m = l + (h - l) / 2;
            
            if (nums[m] == target) {
                return 1;
            }

            if (nums[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;

        if (search(nums, target) == 1) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }

    }

}
