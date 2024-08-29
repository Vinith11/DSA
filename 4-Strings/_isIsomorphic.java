
import java.util.HashMap;

public class _isIsomorphic {
    
    /*
     * Steps:
     * 
     * 1. We'll use indexS and indexT array for Hashing pupose so side of array will be 200
     * 2. Len of s and t must be equal else return false
     * 3. iterate through string length i.e i=0 to s.length()
     *    check if indexS[s.charAt(i)] != indexT[t.charAt(i)]
     *              return false
     *    example s = add and t = egg
     *    s.charAt(i) = a and t.charAt(i) = e
     *    indexS[a] and indexS[e]
     *    
     *    since it is an INT array where CHAR is an index so ascii is taken
     *    indexS[97] and indexT[101]
     * 4. if they are same then the frequency is updated  
     * 
     */
    public static boolean isIsomorphic1(String s, String t) {
        int[] indexS = new int[200];
        int[] indexT = new int[200];

        int len = s.length();

        if(len != t.length()){
            return false;
        }

        for(int i=0; i<len; i++){
            if(indexS[s.charAt(i)] != indexT[t.charAt(i)]){
                return false;
            }

            indexS[s.charAt(i)] = i+1;
            indexT[t.charAt(i)] = i+1;
        }

        return true;
    }


    public static boolean isIsomorphic2(String s, String t) {
        HashMap<Character, Character> iso = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(iso.containsKey(s.charAt(i))){
                if(!iso.get(s.charAt(i)).equals(t.charAt(i))){
                    return false;
                }             
            }else{
                if(iso.containsValue(t.charAt(i))){
                    return false;
                }
                iso.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }


    
    public static void main(String[] args) {
        String a="egg";
        String b="ahd";
        System.out.println(isIsomorphic2(a,b));
    }
}
