public class _movezeros {

    public static int[] method1(int nums[]) {

        int n = nums.length;
        int countZ = 0;
        int j = 0;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                countZ++;
            } else {
                ans[j] = nums[i];
                j++;
            }
        }

        for (int i = j + 1; i < n; i++) {
            ans[i] = 0;
        }

        return ans;
    }

    public static int[] method2(int nums[]) {

        int n = nums.length;
        int temp;

        if (n == 1) {
            return nums;
        }

        int i = 0;

        for(int j=0; j<n; j++){
            if(nums[j]!=0 && nums[i] == 0){
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }

            if(nums[i] != 0){
                i++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        int n = nums.length;

        // int ans[] = method1(nums);
        method2(nums);
        int ans[] = nums;

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
