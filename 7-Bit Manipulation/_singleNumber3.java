public class _singleNumber3 {
    
    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0; i<nums.length; i++) {
            xor ^= nums[i];
        }

        int res[] = new int[2];

        int setBit = (xor & xor-1) ^ xor;
        for(int i=0; i<nums.length; i++) {
            if((nums[i] & setBit) == 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 2, 5 };
        int[] ans = singleNumber(nums);
        System.out.println("Single numbers are: " + ans[0] + " and " + ans[1]);
    }

}
