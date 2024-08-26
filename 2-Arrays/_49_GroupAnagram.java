
import java.util.*;

public class _49_GroupAnagram {

    /*
     * Steps:
     * 
     * 1. Create a hashmap to store Sting and List<String>
     * 2. Iterate through the input array of strings, convert string toCharArray and sort it
     * 3. Convert the sorted char array to string
     * 4. Check if the sorted string is present in the hashmap
     * 5. If not present, add the sorted string as key and new ArrayList as value
     * 6. Add the original string to the list of the sorted string key
     * 
     * 
     * Time complexity is O(n * k * log(k)),
     *  where: n is the number of strings in str. k is the maximum length of a str.
     * 
     */
    public static List<List<String>> method1(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());

    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // Call method1 to get the result
        List<List<String>> result = method1(input);

        // Iterate through the result and print each list
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
