
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _347_topKfreq {

    /*
     * Sorting
     * 
     * 1. declare a hashmap to store the frequency of each element
     * 2. Run a for loop, if number doesnt exist then add it and initialize it with 1
     *    If it exists, increment the frequency
     * 3. Create a 2D array to store the element and its frequency
     * 4. Sort the 2D array by frequency in accending od decnding order
     * 5. Put the top k frequent elements in the final array
     * 
     * Time complexity: O(nlogn)
     */
    public static int[] method1(int[] nums, int k) {
        // We want to first map out the frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        // our map is: {element: frequency}
        // then we put it into an array 
        int n = map.size();
        int[][] arr = new int[n][2];

        int idx = 0;
        for (Integer i : map.keySet()) {
            arr[idx][0] = i;
            arr[idx][1] = map.get(i);
            idx++;
        }

        // sort it by frequencies
        // This sorting is performed in ascending order. 
        // If you want to sort in descending order, you can use the following lambda expression:
        // Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));



        System.out.println("Sorted array: ");
        for(int i=0; i<n; i++){
            System.out.println(arr[i][0] + " " +arr[i][1]);
        }

        // put top k frequent elements in the final array
        int[] res = new int[k];
        idx = 0;

        for (int i = n - 1; i > n - 1 - k; i--) {
            res[idx++] = arr[i][0];
        }
        return res;

    }


    /*
     * Bucket Sort
     * 
     * 1. declare a hashmap to store the frequency of each element
     * 2. Run a for loop, if number doesnt exist then add it and initialize it with 1
     *   If it exists, increment the frequency
     * 3. Create a bucket array to store the ArrayList(of length = nums.len) of element w.r.t index, 
     *    ex: if 3 has occured 2 times then bucket[2]=[3]
     * 4. Create a result array of length k and idx = 0 as index of res array
     * 5. Iterate through the bucket array in reverse order and check if bucket is not null, then step 6
     * 6. Iterate thraugh bucket ArrayList till j<bucket[i].size() && idx<k
     * 7. res[idx] = bucket[i].get(j);
     *    idx++;
     * 8. resturn res;
     * 
    */
    public static int[] method2(int[] nums, int k){

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] res = new  int[k];
        int idx=0;

        for(int i=bucket.length - 1; i>=0; i--){
            if(bucket[i]!=null){
                for(int j=0; j<bucket[i].size() && idx<k; j++){
                    res[idx] = bucket[i].get(j);
                    idx++;
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] input = {1, 1, 1, 2, 2, 3};
        int k = 2;

        // Call method1 to get the result
        int[] result = method2(input, k);

        // Print the result
        for (int i : result) {
            System.out.println(i);
        }
    }
}
