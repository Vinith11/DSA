
import java.util.HashMap;
import java.util.Map;

public class _longSubArrSumK {

    // brute force
    public static int method1(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    public static int method2(int[] arr, int k) {
        int n = arr.length;

        int maxLen = 0;
        int sum = 0;
        Map<Integer, Integer> remSum = new HashMap<>();

        for(int i=0; i<n; i++){

            //sum till index i
            sum+=arr[i];

            // When subarray starts from index '0'
            if (sum == k) {
                maxLen = i + 1;
            }

            //if sum is not present in Hashmap
            if(!remSum.containsKey(sum)){
                remSum.put(sum, i);
            }

            // check if reminder = sum - k is present
            if(remSum.containsKey(sum - k)){

                //update maxLen
                maxLen = Math.max(maxLen, i - remSum.get(sum - k));
            }
             
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 5, 2, 7, 1, 9 };
        int k = 15;
        // System.out.println(method1(arr, k));
        System.out.println(method2(arr, k));
    }
}
