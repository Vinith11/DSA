
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _128_LongestConsecutiveSeq {

    /*
     * Brute Force
     * 
     * Steps
     * 
     * 1. we create a variable longSeq to store the longest sequence
     * 2. we iterate over the array where we take the current element as currNum and initialize currSeq to 1
     * 3. we check if the current element + 1 is present in the array
     * 4. if it is present then we increment the currNum and currSeq
     * 5. we update the longSeq with the maximum of longSeq and currSeq
     * 6. return the longSeq
     * 
     * Time Complexity: O(n^3)
     */
    public static boolean longConc(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

    public static int method1(int[] nums) {
        int n = nums.length;
        int longSeq = 0;
        for (int num : nums) {
            int currNum = num;
            int currSeq = 1;
            while (longConc(nums, currNum + 1)) {
                currNum++;
                currSeq++;
            }
            longSeq = Math.max(longSeq, currSeq);
        }
        return longSeq;
    }

    /*
     * Solved using Array + Sorting. Brute Better Approach.
     * 
     * Time Complexity: O(nlogn)
     */
    public static int method2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int currSeq = 1;
        int longSeq = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] != nums[i]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currSeq++;
                } else {
                    longSeq = Math.max(longSeq, currSeq);
                    currSeq = 1;
                }
            }
        }

        return Math.max(longSeq, currSeq);

    }

    /*
     * Solved using HashSet
     * 
     * Steps
     * 1. we create a hashset and add all the elements of the array to it and put all number in array in map as true
     * 2. we iterate over the array and check if the current element - 1 is present in the map to find the starting point of the sequence
     * 3. if it is present then we update the value of the current element to false
     * 4. we iterate over the array and find the starting point of the sequence we enter a loop to find the length of the consecutive sequence.
     * 5. we check if the current element key is present in hashmap and increment the count++ and j++
     * 6. we update the maxLen with the maximum of maxLen and count
     * 
     * Time Complexity: O(n)
     */
    
     public static int method3(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, true);
        }
        for (int num : nums) {
            if (map.containsKey(num - 1)) {
                map.put(num, false);
            }
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (map.getOrDefault(nums, true)) {
                int j = 0;
                int count = 0;
                while (map.containsKey(nums[i] + j)) {
                    count++;
                    j++;
                }
                if (count > maxLen) {
                    maxLen = count;
                }

            }
        }

        return maxLen;
    }


    /*
     * Array + Hash Table (Unordered set)
     * 
     * Steps
     * 
     * 1. we create a hashset and add all the elements of the array to it and initialize longSeq to 0
     * 2. we iterate over the array and check if the current element - 1 is present in the hashset to find the starting point of the sequence
     * 3. if it is not present then we update the currNum with the current element and currSeq with 1(which indiactes it is the starting point of the sequence)
     * 4. we enter a loop to find if the consicutive num is there in set if yes then curNum++ currSwq++ 
     * 5. we update the longSeq with the maximum of longSeq and currSeq
     * 
     * 
     * Time Complexity: O(n)
     */
    public static int method4(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int longSeq = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currSeq = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currSeq++;
                }
                longSeq = Math.max(longSeq, currSeq);
            }
        }

        return longSeq;

    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(method4(arr));
    }
}
