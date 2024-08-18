
import java.util.*;

public class _242_ValidArhu{

    /*
     * Sorting
     * 
     *  time complexity isF O(n log n)
     */
    public static boolean method1(String s, String t){
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    /*
     * Hash Table
     * 
     * Steps:
     * 
     * 1. First we count char freq in String S and add in HahMap
     * 2. Then we count char freq in String T and if it exists then we -1 freq
     * 3. If the freq is not 0 then return false
     * 
     * time complexity is O(n)
     */
    public static boolean method2(String s, String t){
        HashMap<Character, Integer> count = new HashMap<>();

        for (char c: s.toCharArray()){
            count.put(c, count.getOrDefault(c,0)+1);
        }
 
        for (char c: t.toCharArray()){
            count.put(c, count.getOrDefault(c,0)-1);
        }

        for(int val: count.values()){
            if(val != 0){
                return false;
            }   
        }

        return true;
    }



    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(method1(s,t));
    }
}