public class _rearrangeArray{

    public static  int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int j = 0;
        int k = 1;
        int ans[] = new int[n];

        for(int i : nums){
            if(i>0){
                ans[j] = i;
                j+=2;
            } else if(i<0){
                ans[k] = i;
                k+=2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        int ans[] = rearrangeArray(nums);

        for(int i: ans){
            System.out.print(i + " ");
        }
    }
}