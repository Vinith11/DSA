
import java.util.Arrays;

public class _getAveragesForKraduis {

    public static int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n];
        long sum = 0;
        int count = 0;

        if(k==0){
            return nums;
        }

        Arrays.fill(ans, -1);

        if(nums.length -1 == k ){
            return ans;
        }

        for(int i=0; i<n; i++){
            sum += nums[i];

            if(i<k || i>=2*k){
                ans[i] = -1;
            }

            if((i - count + 1) == 2*k+1){
                int avg = (int) (sum/(2*k+1));
                ans[count+k] = avg;
                sum-= nums[count];
                count++;
            }
        }

        return ans;
    }
    

    public static void main(String[] args) {
        // int[] nums = {7,4,3,9,1,8,5,2,6};
        int[] nums = {40527,53696,10730,66491,62141,83909,78635,18560};
        int k = 2;
        int ans[] = getAverages(nums, k);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
        
    }
}
