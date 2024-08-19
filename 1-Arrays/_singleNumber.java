
import java.util.Arrays;

public class _singleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};

        int n = nums.length;
        Arrays.sort(nums);

        for(int i=1; i<n; i+=2){
            if(nums[i-1] != nums[i]){
                System.out.println(nums[i-1]);
            }
        }

        System.out.println(nums[n-1]);
    }
}
