import java.util.*;

public class _encodeDecode{

    public static String encode(List<String> strs) {
        if(strs.isEmpty()) return "";

        StringBuilder str = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();

        for(String s:strs){
            sizes.add(s.length());
        }

        for(int size:sizes){
            str.append(size).append(',');
        }
        str.append('#');

        for(String s:strs){
            str.append(s);
        }

        return str.toString();
    }

    public static List<String> decode(String str) {
        if(str == "") return new ArrayList<>();

        List<String> strs = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();  
        
        int i = 0;

        while(str.charAt(i) != '#'){
            StringBuilder temp = new StringBuilder();
            while(str.charAt(i) != ','){
                temp.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(temp.toString()));
            i++;
        }
        i++;
        for(int s:sizes){
            strs.add(str.substring(i, i+s));
            i+=s;
        }

        return strs;
    }
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("Hello");
        strs.add("World");
        strs.add("Java");
        String encoded = encode(strs);
        System.out.println("Encoded String: " + encoded);

        List<String> decoded = decode(encoded);
        System.out.println("Decoded String : " + decoded);
    }

}