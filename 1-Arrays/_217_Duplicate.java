
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _217_Duplicate {


    /* 
     * Brute force 
     * 
     *  time complexity of O(n^2)
     */
    public static boolean method1(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }


    /*
     * Sorting
     * 
     * Time complexity is O(n log n)
     */
    public static boolean method2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    /*
     * Hash Set
     * 
     * Time complexity is O(n)
     */
    public static boolean method3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    /*
     * Hash Map
     * 
     * Time complexity is O(n)
     */
    public static boolean method4(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num) && map.get(num) >= 1) {
                return true;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(method4(nums));
    }

}
