
import java.util.*;

public class _romanToInt {
    
    public static int romanToInt(String s) {
        int ans = 0;
        HashMap<Character, Integer> romVal = new HashMap<>();
        romVal.put('I', 1);
        romVal.put('V', 5);
        romVal.put('X', 10);
        romVal.put('L', 50);
        romVal.put('C', 100);
        romVal.put('D', 500);
        romVal.put('M', 1000);

        /*
         * Take example of "IX" i.e 9 and "XI" i.e 11
         * 
         * We will if current value is less than the next value as this format indicates that 
         * the less value is subtracted from the Large value
         * 
         * Take "IX" here I is less than X so ans will be X - I i.e 9
         * 
         * If The current value is not less than next value we add it directly 
         * Take "XI" here X is not less than I so ans is X + I i.e 11
         */
        for(int i=0; i<s.length(); i++){
            if(i<s.length()-1 && romVal.get(s.charAt(i)) <romVal.get(s.charAt(i+1))){
                ans -= romVal.get(s.charAt(i)); 
            } else{
                ans += romVal.get(s.charAt(i));    
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "XI";
        System.out.println(romanToInt(s));    
    }
}
