
import java.util.HashSet;

public class _findSubarraysKlen {

    /*
     * With HashSet
     */
    public static boolean findSubarrays1(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (set.contains(nums[i] + nums[i + 1])) {
                return true;
            }
            set.add(nums[i] + nums[i + 1]);
        }
        return false;
    }

    /*
     * With array
     */
    public boolean findSubarrays(int[] nums) {
        int[] sums = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];

            for (int j = 0; j < i; j++) {
                if (sums[j] == sum) {
                    return true;
                }
            }

            sums[i] = sum;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(findSubarrays1(nums));
    }
}
