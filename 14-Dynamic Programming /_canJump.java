public class _canJump {
    public static boolean canJump1(int[] nums) {
        int n = nums.length;
        int goal = n -1;
        for(int i=n-2; i>=0; i--){
            if(i+nums[i]>=goal){
                goal=i;
            }
        }
        return goal == 0;
    }

    public static boolean canJump2(int[] nums) {
        int goal = 0;
        for(int n:nums){
            if (goal<0){
                return false;
            } else if(n>goal){
                goal=n;
            }
            System.out.println(goal);
            goal--;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump2(nums));
    }
}
