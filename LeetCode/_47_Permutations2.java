
import java.util.*;
/*
 * Approach: The approach is to use backtracking to generate all possible
 * Here we will not go ahead with regular method of backtracking as we did in _46_Permutations.java
 * Since we have duplicates in the array, we need to handle them separately.
 * 
 * Example: nums = [1, 1, 2]
 * take node nums[0] = 1, as start, next node can be 1 or 2 and then 2 or respectively 
 * Now we have unique array [[1,1,2],[1,2,1],[2,1,1]]
 * but when we move to next node nums[1] = 1, we have already considered this node in the previous step
 * Simalarly, when we move to next node nums[2] = 2, when we take its cildren are 1 and 1 nd their children 1 and 1 which is again wrong 
 * 
 * So we use haspMap to keep track of the nodes we have already considered
 * 
 * 
 * 
 * Using HashMap
 * We will keep no. as key and count its value 
 * So start node will be 1, 2 instead of 1, 1, 2
 * And then next node will be choosen through the map, if the count is 0, we will not consider that node
 * else we will consider that node and reduce its count by 1
 * 
 * We will backtrack as it is 
 * Once done we will remove recenty added node and increase its count by 1
 * 
 * Time Complexity: O(n * n!) where n is the length of the input array
 * 
 */

 public class _47_Permutations2 {
 
     public List<List<Integer>> permuteUnique(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
         List<Integer> perm = new ArrayList<>();
         Map<Integer, Integer> count = new HashMap<>();
 
         for (int n : nums) {
             count.put(n, count.getOrDefault(n, 0) + 1);
         }
 
         dfs(nums.length, perm, count, res);
         return res;
     }
 
     private void dfs(int length, List<Integer> perm, Map<Integer, Integer> count, List<List<Integer>> res) {
         if (perm.size() == length) {
             res.add(new ArrayList<>(perm));
             return;
         }
 
         for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
             int n = entry.getKey();
             int cnt = entry.getValue();
             if (cnt > 0) {
                 perm.add(n);
                 count.put(n, cnt - 1);
                 dfs(length, perm, count, res);
                 perm.remove(perm.size() - 1);
                 count.put(n, cnt);
             }
         }
     }
 
     public static void main(String[] args) {
        _47_Permutations2 solution = new _47_Permutations2();
         int[] nums = {1, 1, 2};
         List<List<Integer>> result = solution.permuteUnique(nums);
         System.out.println(result);
     }
 }
 