
public class _704_BinarySearch {

    public static int method1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        if (l == r && nums[l] == target) {
            return l;
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if(nums[mid]<target){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return -1;
    }

    public static int method2(int[] nums, int target) {

        int l=0, r = nums.length-1;
        return binarySearch(nums, l, r, target);
    }

    public static int binarySearch(int[] nums, int l, int r, int target){
        if(l>r){
            return -1;
        }

        int mid = l + (r-l)/2;

        if(nums[mid]==target){
            return mid;
        }

        if(nums[mid]<target){
            return binarySearch(nums, mid+1, r, target);
        } else {
            return binarySearch(nums, l, mid-1, target);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 8};
        int target = 8;
        System.out.println(method2(arr, target));
    }
}
