
import java.util.ArrayList;
import java.util.List;

/*
 * Here the approach used is recursion related 
 */
public class _78_Subsets {

    /*
     *  Recursion Tree
     * Assume nums = [1, 2, 3] is the array and we want to find power set of it 
     * There will also be an empty array along with it to store states 
     * 
     * we will split in nclude and exlude, so first iteration would look like
     *                    [1,2,3][]              i=0
     *             Exlude/         \include
     *          [1,2,3][]           [1,2,3][1]
     *   Exlude/        \include                 i=1
     * [1,2,3][]       [1,2,3][2] 
     *          Exlude/        \include          i=2
     *        [1,2,3][2]       [1,2,3][2,3]
     * 
     * If we do it to all then we get [1,2,3]and all power sets         
     */

 /*
     * Recursion Approach
     * 
     * Steps for subsets:
     * 1. We will create an empty array to store final answer of type List<List<Integer>> and a List to store output
     * 2. We will sent nums array, final array, output array with index to BACKTRACK method
     * 
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        backtrack(ans, output, nums, 0);
        return ans;
    }

    /*
     * Steps for backtrack
     * 1. Base Case: if index==nums.length add output as Arraylist in final ans array and then return;
     * 2. To exclude index we simply in recursion send index+1
     * 3. To include we will add the num[index] in output list, and then again backtrack then we remove last element of ouput
     */
    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
