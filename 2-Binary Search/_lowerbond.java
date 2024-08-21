public class _lowerbond {

    public static int lowerBound(int[] nums, int n, int floor) {

        int l = 0;
        int h = n - 1;
        int index=n;

        while (l <= h) {
            int m = l + (h - l) / 2;
            int ele = nums[m];
            

            // if we fin that mid is greater than floor then we will update the index
            // since we are finding lower bond so we will move left as we have to find smallest index 
            if (ele >= floor) {
                index = m;
                h = m - 1;                
            } else {
                // if we dont mid is less than floor then we will move towards right
                // as a there may be a chance that number may exist in right
                l = m + 1;
            }

        }

        return index;
    }    

    public static void main(String[] args) {
        int[] nums = { 1, 2, 8, 10, 11, 12, 19 };
        int floor = 5;
        int n = nums.length;
        
        int ans = lowerBound(nums, n, floor);
        System.out.println(ans);

    }    
}
