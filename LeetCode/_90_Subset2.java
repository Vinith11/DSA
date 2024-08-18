
import java.util.*;

    /**
     * Generates all subsets of the given array, ensuring no duplicate subsets.
     *
     * Approach:
     * - The array is first sorted to bring duplicates together.
     * - A backtracking approach is used to explore all possible subsets.
     * - During the backtracking, we skip adding duplicates by checking if the current element 
     *   is the same as the previous one and if it has been processed in the current recursive step.
     *
     * Steps:
     * 1. Sort the input array to handle duplicates easily.
     * 2. Call the `backtrack` method with an empty list to start generating subsets.
     * 3. In the `backtrack` method:
     *    a. Add the current subset (tempList) to the list of subsets.
     *    b. Loop through the array starting from the given index.
     *    c. If the current element is the same as the previous one (and not at the start index), skip it to avoid duplicates.
     *    d. Include the current element in the subset and recursively call `backtrack` for the next elements.
     *    e. After the recursive call, remove the last element from the current subset to backtrack and explore other possibilities.
     * 4. Continue the process until all subsets are generated and added to the list.
     *
     * Time Complexity: (n log n + n * 2^n).
     *

     */

public class _90_Subset2{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; 
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    } 

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        _90_Subset2 obj = new _90_Subset2();
        List<List<Integer>> result = obj.subsetsWithDup(nums);
        System.out.println(result);
    }
}