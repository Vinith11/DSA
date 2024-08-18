public class _153_FindMinInArr {

    public static int method1(int[] nums){
        int l=0;
        int r=nums.length-1;

        while(l<r){
            int mid = l + (r-l)/2;

            if(nums[mid]>nums[r] ){
                l=mid+1;
            } else{
                r=mid;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(method1(arr));
    }
    
}
