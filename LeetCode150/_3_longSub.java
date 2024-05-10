import java.util.*; 
  

public class _3_longSub{


    /*
     * Sliding Window and set
     * 
     * Steps:
     * 1. left =0, is a pointer of sliding window
     *    max_len is ans
     *    char_set to keep set of char
     * 2. right = 0, is a pointer of sliding window
     * 3. r and l will move to right, left stays at start and right moves
     * 4. if char is not in set, add it to set and move right, after that check max_len = right - left + 1
     * 5. if char is in set, remove it from set and move left, then do like step 4
     * 
    */
    public static int method1(String s) {
        int left = 0;
        int maxLength = 0;
        HashSet<Character> charSet = new HashSet<>();

        for(int right=0; right < s.length(); right++){
            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;

    }

    /*
     * Sliding Window and hashing
     * 
     * in hashmap we keep char as key and frequency as value
     * if we find char in hashmap we add 1 freq to map
     * if freq is more than 2 we add -1 until freq is 1, and move left to next
     * 
     * 
     * 
    */
    public static int method2(String s) {
        int maxLength = 0;
        int left = 0;
        HashMap<Character, Integer> count = new HashMap<>();

        for(int right=0; right< s.length(); right++){
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c, 0)+1);

            while(count.get(c)>1){
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar)-1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;        
    }

    /*
     * the last position where each character was seen
     * 
     * 
     */

     public static int method3(String s) {
         int maxLength = 0;
         int left = 0;
         Map<Character, Integer> lastSeen = new HashMap<>();

         for(int right=0; right<s.length(); right++){
             char c = s.charAt(right);

             if(lastSeen.containsKey(c) && lastSeen.get(c) >= left){
                 left = Math.max(left, lastSeen.get(c)+1);
             }
             
             maxLength = Math.max(maxLength, right - left + 1);
             lastSeen.put(c, right);
         }

         return maxLength;
     }


    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(method3(s));
    }
}