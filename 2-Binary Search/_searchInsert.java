public class _searchInsert {

    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (nums[m] == target) {
                return m;
            } else if (target > nums[m]) {
                l = m + 1;
            } else{
                h = m - 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 3, 5, 6 };
        int target = 5;

        System.out.println(searchInsert(nums, target));
    }

}
