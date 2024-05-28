
import java.util.Arrays;

public class _567_PermutationStr {
    

    /*
     * Sliding window approach
     * 
     * Steps:
     * 1. Initialize an array arr of size 26 to count the occurrences of characters in s1.
     * 2. Iterate through each character in s1 and increment the corresponding count in arr.
     * 3. Initialize two pointers, l and r, to track the window of s2 that we're considering.
     * 5. Iterate through each character in s2 using the r pointer:
     *            i. Update the count of the current character in the window of s2.
     *            ii. Check if the counts in the current window of s2 match the counts in arr using the isEqual() function.
     *            iii. If the counts match, return True.
     *            iv. If the counts don't match, move the l pointer until the counts match again.
     * 6. If no matching substring is found, return False.
     * 
     * 
     * Time complexity: O(n) 
     * Space complexity: O(1)
     * 
    */
    public static boolean method1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] count = new int[26];
        
        // Count the frequency of characters in s1
        for (int i = 0; i < n; i++) {
            count[s1.charAt(i) - 'a']++;
        }
        
        int l=0;
        int[] subArray = new int[26];
        for (int r = 0; r < m; r++) {
            subArray[s2.charAt(r) - 'a']++;
            if (r - l + 1 == n) {
                if (Arrays.equals(count, subArray)) {
                    return true;
                }
                //if the window is not equal, then we need to move the l pointer and delete the l character from the subarray
                subArray[s2.charAt(l) - 'a']--;
                //this l will reset the subarray start
                l++;
            }
        }

        return false;
    }



    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(method1(s1, s2));
    }
}
