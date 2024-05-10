
import java.util.*;

public class _1_twoSum {

    /* 
     * Brute force
     * 
     * direct aproach where two loops are used 
     * 
     * time complexity is O(n^2).
     */
    public static int[] method1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // No solution found
    }

    /*
     * Two-pass Hash Table
     *
     * 1. Create a hashmap to store the element and its index
     * 2. Iterate through the array and put the element and its index in the hashmap
     * 3. Iterate through the array and check if the complement(target - nums[i]) is present in the hashmap and the index is not the same
     * 4. If present, return the index of the current element and the index of the complement
     * 
     */
    public static int[] method2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }

        return new int[]{}; // No solution found
    }

    /*
     * One-pass Hash Table
     * 
     * 1. Create a hashmap to store the element and its index
     * 2. Iterate through the array and check if the complement(target - nums[i]) is present in the hashmap
     * 3. If present, return the index of the complement and the index of the current element
     * 4. If not present, put the element and its index in the hashmap
     */
    public static int[] method3(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; // No solution found
    }

    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        int target = 9;

        int[] result = method3(input, target);
        System.out.println(Arrays.toString(result));
    }
}
