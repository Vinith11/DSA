public class _removeDuplicatesII {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 2;

        if(n<=2){
            return n;
        }

        for(int i=2; i<n; i++){
            if(nums[i] != nums[j-2]){
                nums[j] = nums[i];
                j++;
            }
        }

        return j;

    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        System.out.println(removeDuplicates(nums));
    }

}
