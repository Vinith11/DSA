import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _majorityElement {

    /*
     * Sorting Method
     * 
     * if we sort the elements then the middle number will be the one that is most frequent
     */
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /*
     * HashMap method
     */
    public static int majorityElement2(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        n = n / 2;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /*
     * Moore Voting Algorithm
     * 
     * 1. The algorithm starts by assuming the first element as the majority candidate and sets the count to 1.
     * 2. As it iterates through the array, it compares each element with the candidate:
     *      a. If the current element matches the candidate, it the count is incremented by 1.
     *      b. If the current element is different from the candidate, it the count is decremented by 1.
     * 3. If the count becomes 0, it means that the current candidate is no longer a potential majority element. In this case, a new candidate is chosen from the remaining elements.
     * 4. The final value of the candidate variable will hold the majority element.
     */
    public static int majorityElement3(int[] nums) {
        int count = 0;
        int candidate = 0;

        for(int i=0; i<nums.length; i++){
            if(count == 0){
                candidate = nums[i];
            }

            if(nums[i] == candidate){
                count++;
            } else{
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 3 };
        System.out.println(majorityElement3(arr));
    }
}
