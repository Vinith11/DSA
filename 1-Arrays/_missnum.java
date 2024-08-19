public class _missnum {
    public static void main(String[] args) {
        int[] nums = {3,0,1};

        int n=nums.length+1;
        int sumOfN = 0;
        for(int i=0; i<n; i++){
            sumOfN+=i;
        }


        n=nums.length;
        int sumOfNums = 0;
        for(int i=0; i<n; i++){
            sumOfNums+=nums[i];
        }

        System.out.println(sumOfN - sumOfNums);
    }
}
