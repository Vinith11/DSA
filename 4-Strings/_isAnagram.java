import java.util.HashMap;

public class _isAnagram {

    public static boolean isAnagram1(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<>();

        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) - 1);
        }

        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram2(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int[] Hash = new int[200];

        for (int i = 0; i < s.length(); i++) {
            Hash[s.charAt(i)] += 1;
        }

        for (int i = 0; i < t.length(); i++) {
            Hash[t.charAt(i)] -= 1;
        }

        for (int i = 0; i < 200; i++) {
            if (Hash[i] != 0 || Hash[i] < 0) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        // Boolean ans = isAnagram1(s, t);
        Boolean ans = isAnagram2(s, t);

        System.out.println(ans);
    }
}
