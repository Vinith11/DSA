/*
 * A string will be given as input. You need to find the lowercase alphabets in the string and return with lentgh of the string.
 * Here the string is "Hello ThiS foR tEst"
 * the lowercase alphabets are "ellohifortest" and the length is 15. So the output is "ellohifortest:15"* 
 * 
 */


public class Problem1 {

    public static String lowerString(String str, int n) {
        String ans = "";
        for (int i = 0; i < n; i++) {
            char temp = str.charAt(i);
            if (temp != ' ') {
                if (islower(temp)) {
                    ans += temp;
                }

                // if (Character.isLowerCase(temp)) {
                //     ans += temp;
                // }
            }
        }

        return ans + ':' + ans.length();
    }

    public static boolean islower(char c) {
        char[] lower = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z' };

        for (int i = 0; i < 26; i++) {
            if (c == lower[i]) {
                return true;
            }
        }
        return false;
    }

    // public static boolean islower(char c) {
    //     return c >= 'a' && c <= 'z';
    // }

    public static void main(String[] args) {
        String str = "Hello ThiS foR tEst";
        System.out.println(lowerString(str, str.length()));
    }
}