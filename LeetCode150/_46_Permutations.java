
import java.util.*;

public class _46_Permutations {

    /*
     * Approach: The approach is to use backtracking to generate all possible
     * permutations of the given array. The backtracking function explores all
     * permutations by adding elements to a temporary list, and if the temporary
     * list reaches the size of the input array, it is added to the result list.
     * The function then removes the last element and continues exploring other
     * permutations.
     *
     * Steps: 
     * 1. Initialize the result list 'list' which will store all permutations. 
     * 2. Call the backtrack function with the initial parameters:
     * - 'list' to store results 
     * - 'tempList' to build the current permutation 
     * - 'nums' the input array 
     * 3. In the backtrack function: 
     *      a. If 'tempList' size equals 'nums' length, add a copy of 'tempList' to 'list'. 
     *      b. Otherwise, loop through the elements in 'nums'. 
     *          i. If 'tempList' already contains 'nums[i]', skip to the next iteration. 
     *          ii. Add 'nums[i]' to 'tempList'. 
     *          iii. Recursively call backtrack with the updated 'tempList'.
     *          iv. Remove the last element from 'tempList' to backtrack.
     *
     * Time Complexity: The time complexity of this algorithm is O(n * n!),
     * where n is the length of the input array. This is because there are n!
     * permutations and adding a permutation to the result list takes O(n) time.
     *
     * Space Complexity: The space complexity is O(n * n!) due to the storage of
     * all permutations in the result list. Additionally, the recursion stack
     * uses O(n) space in the worst case.
     */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue; // element already exists, skip
                }
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        _46_Permutations obj = new _46_Permutations();
        List<List<Integer>> result = obj.permute(nums);
        System.out.println(result);
    }
}
