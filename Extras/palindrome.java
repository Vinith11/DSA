
public class palindrome {

    public static boolean method1(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public static boolean recursion(char[] s, int i, int j) {
        if (i > j) {
            return true;
        }

        if (s[i] != s[j]) {
            return false;
        }else{
            return recursion(s, i+1, j-1);
        }

        
    }



public static boolean method2(String s) {
        if (s.isEmpty()) {
            return true;
        }

        char[] arr = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        boolean res = recursion(arr, l, r);

        return res;

    }

    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(method2(s));
    }
}
