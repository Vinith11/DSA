import java.util.HashMap;
import java.util.Map;

public class Q25 {
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5, 6, 6, 7, 4};
            Map<Integer, Integer> freq = new HashMap<>();
    
            for (int num : arr) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
    
            freq.forEach((key, value) -> System.out.println(key + " " + value));
        }
}
    
