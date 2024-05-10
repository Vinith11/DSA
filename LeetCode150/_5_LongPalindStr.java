public class _5_LongPalindStr{
    

    /*
     * Brute Force Method
     * 
     * Step
     * 1. pick string from 0 to n-2
     * 2. now pick ending index from i+1 to n-1
     * 3. check if the string from ith index to jth index is palindrome or not
     * 4. If step 3 is true and length of substring is greater than maximum length so far, update maximum length and maximum substring.
     * 5. Print the maximum substring.
     */

     public static int method1(String s){
        if(s.length() <=1){
            return s.length();
        }

        int maxLen=1;
        String maxStr = s.substring(0,1);

        for(int i=0; i<s.length(); i++){
            for(int j=i+maxLen; j<=s.length(); j++){
                if(j-i > maxLen && isPalindrome(s.substring(i, j))){
                    maxLen = j-i;
                    maxStr = s.substring(i, j);
                }
            }
        }

        return maxLen;

     }

     public  boolean isPalindrome(String s){
        int left=0;
        int right = s.length()-1;

        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
        }
     }



    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}