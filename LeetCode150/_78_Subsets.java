
import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {

    public static void solve(int index, int[] nums, List<List<Integer>> result,List<Integer> output) {
        //base case
        if (index >= nums.length) {
            result.add(new ArrayList<>(output));
            return;
        }

        output.add(nums[index]);
        //exclude
        solve(index+1, nums, result, output);

        //include
        output.remove(output.size()-1);

        solve(index+1, nums, result, output);
    }

    public static List<List<Integer>> method1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(0, nums, result, output);

        return result;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = method1(nums);
        System.out.println(result);
    }
}
