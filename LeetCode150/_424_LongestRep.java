public class _424_LongestRep {

    /*
     * Brute force approach
     * 
     * Approach:
     * we will create an array count of size 26 to store the frequency of each character in the substring. and then we will find which char has max frequency.
     * then we will find the number of changes needed to make the substring all one character. 
     * if the number of changes needed is less than or equal to k then we will update the maxLength.
     */
    public static int method1(String s, int k){
        int maxLength = 0;
        int n = s.length();
        
        // Iterate through all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] count = new int[26];
                for (int l = i; l <= j; l++) {
                    count[s.charAt(l) - 'A']++;
                }

                // Find the most frequent character in the substring
                int maxFreq = 0;
                for (int c = 0; c < 26; c++) {
                    maxFreq = Math.max(maxFreq, count[c]);
                }

                // Number of changes needed to make the substring all one character
                int changesNeeded = (j - i + 1) - maxFreq;

                // Check if within allowed number of changes
                if (changesNeeded <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        
        return maxLength;
    }

    /*
     * Sliding window approach
     */
    public static int method2(String s, int k){
        int maxLength = 0;
        int n = s.length();
        int[] count = new int[26];
        int maxFreq = 0;
        int start = 0;
        
        for (int end = 0; end < n; end++) {
            count[s.charAt(end) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(end) - 'A']);
            
            // If the number of changes needed to make the substring all one character is greater than k
            // Move the start pointer to the right
            while (end - start + 1 - maxFreq > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    
    }
    

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        System.out.println(method2(s, k));
    }
}
