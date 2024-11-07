
import java.util.Arrays;

public class _singleNumber {

    public static int singleNumber1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 1; i < n; i += 2) {
            if (nums[i - 1] != nums[i]) {
                System.out.println(nums[i - 1]);
            }
        }

        return nums[n - 1];
    }

    public static int singleNumber2(int[] nums) {
        int xor = 0;

        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };

        System.out.println(singleNumber2(nums));
    }
}
