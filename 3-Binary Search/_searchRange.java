public class _searchRange {

    public static int[] method1(int[] nums, int target) {
    
        int first = leftSearch(nums, target);
        int last = rightSearch(nums, target);

        return new int[]{first, last};
    }

    public static int leftSearch(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int index = nums.length;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (nums[m] == target) {
                index = m;
                h=m-1;
            }else if (nums[m] < target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return index;
    }

    public static int rightSearch(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int index = -1;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (nums[m] == target) {
                index = m;
                l=m+1;
            }else if (nums[m] < target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 7, 7, 8, 8,8, 10 };
        int target = 8;

        int[] ans = method1(nums, target);

        System.out.println("First: " + ans[0] + "\nLast: " + ans[1]);
    }
}