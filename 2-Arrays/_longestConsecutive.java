
import java.util.HashSet;

public class _longestConsecutive {
    

    //Brute Force
    public static int longestConsecutive1(int[] nums){
        int n=nums.length;
        int longSeq = 0;

        for(int i=0; i<n; i++){
            int currNum = nums[i];
            int currSeq = 1;
            while(checkSeq(nums, currSeq + 1)){
                currNum++;
                currSeq++;
            }
            longSeq = Math.max(currSeq, longSeq);
        }
        return longSeq;
    }

    public static boolean checkSeq(int[] nums, int target){
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                return true;
            }
        }
        return false;
    }

    //optimised way
    public static int longestConsecutive(int[] nums){
        HashSet<Integer> set = new HashSet<>();

        for(int i: nums){
            set.add(i);
        }
        int longSeq = 0;
        for(int num:nums){
            // we need to find num - 1 exists or not too check if the num is starting of seqence or not
            // example take 3, 3-1 = 2 which exists so 3 is not starting point 
            // take 1, 1-1 = 0 since 0 is not in set so it indicates that this is stating point   
            if(!set.contains(num - 1)){
                int currSum = num;
                int currSeq = 1;
                while(set.contains(currSum + 1)){
                    currSum++;
                    currSeq++;
                }
                longSeq = Math.max(currSeq, longSeq);
            }
        }

        return longSeq;
    }
        

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive1(nums));
    }
}
