
public class _upperbond {

    public static int upperbond(int[] nums, int n, int floor) {
        int l = 0;
        int h = n - 1;
        int index = -1;

        if (l == h && nums[l] >= floor) {
            return l;
        }

        while (l <= h) {
            int m = l + (h - l) / 2;
            int ele = nums[m];

            if (ele > floor) {
                index = m;
                h = m - 1;
            } else {
                l = m + 1;
            }

        }
        return index;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 8, 10, 11, 12, 19 };
        int floor = 5;
        int n = nums.length;

        int ans = upperbond(nums, n, floor);
        System.out.println(ans);

    }
}
