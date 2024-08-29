
import java.util.Arrays;


/*
 * Steps
 * 
 * 1. Sort the Strings array beacuse it will help in alinging the words
 *    Suppose initial array was ["flower","flow","flight"]
 *    After Sorting the Array would be
 *    flight
 *    flow
 *    flower
 *    
 *    This will arrange the array in such a way that
 *    i=0 will have least common prefix 
 *    as we go on increasing index wee will observe length pf common prefix increasing
 *    i = array.length-1 will have the most common prefix (last element)
 * 
 * 2. No we will return the common substring
 * 
 */
public class _longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs){
        Arrays.sort(strs);

        for(String word : strs){
            System.out.print(word + " ");
        }

        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int i  = 0;
        while(i<s1.length() && i<s2.length()){
            if(s1.charAt(i) == s2.charAt(i)){
                i++;
            } else{
                break;
            }
        }
        return s1.substring(0, i);
    }

    public static void main(String[] args) {
        // String[] strs = {"flower","flow","flight"};
        String[] strs = {"flower","flow","fpght"};
        System.out.println(longestCommonPrefix(strs));
    }
}
