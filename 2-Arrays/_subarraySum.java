
import java.util.HashMap;

public class _subarraySum {

    public static int subarraySum(int[] nums, int k)   {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int currSum = 0;
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            currSum+=nums[i];

            if(map.containsKey(currSum - k)){
                ans+= map.get(currSum - k);
            }
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return ans;
    }
    

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        int k = 3;
        System.out.println(subarraySum(nums, k));
        
    }
}
