public class _647_PalindromicStr {

    /*
     * Brute Force
     * 
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public static int method1(String s) {
        int ans = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPlaindrome(s,i,j)){
                    ans++;
                }
            }
        }

        return ans;
    }

    public static boolean isPlaindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /*
     * Expanding from middle
     * 
     * Time Complexity: O(n^2 )
     * Space Complexity: O(1)
     */
    public static int method2(String s) {
        int ans = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            int odd = isPlaindrome2(s, i-1, i+1);
            int even = isPlaindrome2(s, i, i+1);
            ans += odd + even + 1;
        }

        return ans;
    }

    public static int isPlaindrome2(String s, int i, int j){
        int count = 0;
        while(i >= 0 && j < s.length() && s.charAt(i--) == s.charAt(j++)) {
            count++;
        }
        return count;
    }

    /*
     * Dynamic Programming
     * 
     * Steps:
     * 1. Initialize a dp table of dimensions len(s) * len(s)
     * 2. Base case: A string with one letter is always a palindrome so we will set i,i  as boolean
     * 3. Base case: Substrings of two letters, we will set i,i+1 as boolean if they are equal 
     * 4. Substrings of lengths greater than 2 we will check if dp[i+1][j-1] is true and s[i] == s[j]
     *    the dp[i+1][j-1] will indicate the in between string of i and j is palindrome or not
     *    s[i], s[j] in the loop will technically be the first and last character of the sub string
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int method3(String s){
        int count = 0;

        // Initialize a lookup table of dimensions len(s) * len(s)
        boolean[][] dp = new boolean[s.length()][s.length()];

        // Base case: A string with one letter is always a palindrome
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count++;
        }

        // Base case: Substrings of two letters
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            count += dp[i][i + 1] ? 1 : 0;
        }

        // Substrings of lengths greater than 2
        for (int length = 3; length <= s.length(); length++) {
            for (int i = 0, j = length - 1; j < s.length(); i++, j++) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                count += dp[i][j] ? 1 : 0;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(method3(s));
    }
    
}
