/*
 * Array of String will be given as input. You need to find the factorial of the length of the 
 * string which has the maximum number of consonants.
 * 
 * Here the array is {"AeIou", "Hello", "weoiu"}
 * they have 0, 3, 1 consonants respectively. So the factorial of the length of the string
 * 3! is returned as output.
 */


public class Problem2 {

    public static int findVowFact(String[] str, int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < str[i].length(); j++) {
                char temp = str[i].charAt(j);
                if (isVowel(temp)) {
                    count++;
                }
            }
            ans = Math.max(ans, str[i].length()-count);
        }

        return fact(ans);
    }

    public static boolean isVowel(char c) {
        char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };

        for (int i = 0; i < vowels.length; i++) {
            if (c == vowels[i]) {
                return true;
            }
        }
        return false;
    }

    public static int fact(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        String[] str = { "AeIou", "Hello", "weoiu" };
        System.out.println(findVowFact(str, str.length));
    }
}
