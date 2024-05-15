
import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        backtrack(nums, output, ans, 0);
        return ans;
    }

    private static void backtrack(int[] nums, List<Integer> output, List<List<Integer>> ans, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

        // exclude
        backtrack(nums, output, ans, index + 1);

        // include
        output.add(nums[index]);
        backtrack(nums, output, ans, index + 1);
        output.remove(output.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        System.out.println(result);
    }
}
