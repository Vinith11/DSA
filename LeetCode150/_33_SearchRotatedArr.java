public class _33_SearchRotatedArr{
    public static int method1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if(nums[l]<=nums[mid]){
                if(target>=nums[l] && target<nums[mid]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }   
            } else {
                if(target>nums[mid] && target<=nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 1, 2 };
        System.out.println(method1(arr, 1));
    }
}