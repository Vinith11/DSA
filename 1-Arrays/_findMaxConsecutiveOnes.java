public class _findMaxConsecutiveOnes {
    
    public static void main(String[] args) {
        //int[] nums = {1,1,0,1,1,1};
        int[] nums = {1,0,1,1,0,1};


        int n=nums.length;
        int ans = 0;
        int i=0;

        for(int j=0; j<n; j++){
            if(nums[j]==1){
                i++;
            } else{
                ans=Math.max(i,ans);
                i = 0;
            }
        }


        System.out.println(Math.max(i,ans));
    }
}
