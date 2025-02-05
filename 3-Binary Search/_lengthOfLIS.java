import java.util.*;

public class _lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for(int i=1; i<nums.length; i++){
            if(nums[i]>temp.get(i-1)){
                temp.add(nums[i]);
            } else{
                int indx = lower_bound(temp, nums[i]);
                temp.set(indx, nums[i]);
            }
        }

        return temp.size();
    }

    private int lower_bound(List<Integer> temp, int key){
        int l = 0;
        int r = temp.size() - 1;

        int m = (l+r)/2;

        while(l<=r){
            if(temp.get(m) == key){
                return m;
            } else if (temp.get(m) > key) {
                r = m -1;
            } else{
                l = m+1;
            }
        }

        return l;
    }
}
