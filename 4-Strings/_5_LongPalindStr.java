public class _5_LongPalindStr{
    

    /*
     * Brute Force Method
     * 
     * Steps:
     * 1. Find all the substrings of the given string.
     * 
     * Time Complexity: O(n^3)
     */
    public static String method1(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLen; j <=s.length(); j++) {
                if (j - i > maxLen && isPalindrome(s.substring(i, j))) {
                    maxLen = j - i;
                    maxStr = s.substring(i, j);
                }
            }
        }

        return maxStr;
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /*
     * Recursiion Method
     * 
     * Steps:
     * 
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public static String method2(String s){
        if(s.equals(new StringBuilder(s).reverse().toString())){
            return s;
        }

        String left = method2(s.substring(1));
        String right = method2(s.substring(0, s.length()-1));

        return left.length() > right.length() ? left : right;
    }


    /*
     * Dynamic Programming Method
     */
    public static String method3(String s){
        if(s.length() <=1){
            return s;
        }

        int maxLen = 1;
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
            for(int j=0; j<i; j++){
                if(s.charAt(i) == s.charAt(j) && (i-j <= 2 || dp[j+1][i-1])){
                    dp[j][i] = true;
                    if(i-j+1 > maxLen){
                        maxLen = i-j+1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end+1);
    }

    /*
     * Expand From Centre 
     * 
     * This Approch is also O(N^2)
     * But it is better than Brute force as we will be cheking if a string is palindrome or not from centre
     * if it is not then the prohram will end quickly which saves execution time
     * 
     */
    public static String method4(String s){
        String ans = s.substring(0, 1);

        for(int i=0; i<s.length()-1; i++){
            String odd = expandCentre(s, i, i);
            String even = expandCentre(s, i, i+1);

            if(odd.length() > ans.length()){
                ans = odd;
            }

            if(even.length() > ans.length()){
                ans = even;
            }

        }

        return ans;
    }

    public static String expandCentre(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(r) == s.charAt(l)){
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }

    

    public static void main(String[] args) {
        String s = "cddb";
        System.out.println(method4(s));
    }
}