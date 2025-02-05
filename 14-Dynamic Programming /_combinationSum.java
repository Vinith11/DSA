import java.util.ArrayList;
import java.util.List;

public class _combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        combination(candidates, target, ans, 0, new ArrayList<>(), 0);

        return ans;
    }

    private void combination(int[] candidates, int target, List<List<Integer>> ans, int idx, List<Integer> comb, int total){
        if(total == target){
            ans.add(new ArrayList<>(comb))
            return;
        }

        if(total>target || idx>=candidates.length){
            return;
        }

        comb.add(candidates[idx]);
        combination(candidates, target, ans, idx, comb, total + candidates[idx]);
        comb.remove(comb.size() - 1);
        combination(candidates, target, ans, idx+1, comb, total);
    }
}
