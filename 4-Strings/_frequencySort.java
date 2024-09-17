
import java.util.*;

public class _frequencySort {
    
    static String frequencySort1(String s) {
        // 1. Store all frequency in Hash map
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i =0; i<s.length(); i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);
        }


        // 2. all of the hash map in 2D Array list
        List<List<Integer>> res  = new ArrayList<>();

        for(Map.Entry<Character, Integer> i: freq.entrySet()){
            List<Integer> temp = new ArrayList<>();

            int a = i.getKey();
            int b = i.getValue();

            temp.add(a);
            temp.add(b);

            res.add(temp);
            // System.out.println(temp);
        }

        // 3. Sort array list
        Collections.sort(res, (a,b)->{
            return b.get(1) - a.get(1);
        });
        

        // 4. construct the string
        String ans ="";
        for(int i=0; i<res.size(); i++){
            int a1 = res.get(i).get(0);
            char a = (char)a1;
            for(int j=0; j<res.get(i).get(1); j++){
                ans += a;
            }
        }
        return ans;
    }

    static String frequencySort2(String s){
        // 1. hashing alphabets 
        int[] hash = new int[200];

        // 2. count frequency
        for(int i=0; i<s.length(); i++){
            hash[s.charAt(i)] += 1;
        }

        //3. list with freqyency and character
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<hash.length; i++){
            List<Integer> temp = new ArrayList<>();
            if(hash[i]>0){
                temp.add(i);
                temp.add(hash[i]);
                res.add(temp);
                System.out.println(temp);
            }
        }

        Collections.sort(res, (a,b)->{
            return b.get(1) - a.get(1);
        });

        String ans = "";
        for(int i=0; i<res.size(); i++){
            int a1 = res.get(i).get(0);
            char a = (char) a1;
            for(int j=0; j<res.get(i).get(1); j++){
                ans += a;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        String str = "tree";
        System.out.println(frequencySort1(str));
    }
}
