public class _linearsearch {

    public static void main(String[] args) {
        
        int[] nums = {1,2,3,4,5,6};
        int k = 6;

        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] == k){
                System.out.println(1);
                break;
            }
        }
        System.out.println(-1);

    }
    
}
