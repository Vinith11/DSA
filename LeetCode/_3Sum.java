
import java.util.*;

public class _3Sum {

    /*
     * Two Pointer Approach
     * 
     * Steps:
     * 1. Sort the array and create an Array to store list of triplets
     * 2. Iterate through the input array only till nums.length-2 as we need 3 nums
     * 3. Check if the current element is same as previous element, if yes then skip
     * 4. Initialize left=i+1 and right=nums.length-1 pointers, now are starting triplets are nums[i], nums[left], nums[right]
     * 5. while loop will run until left<right
     * 6. Calculate the sum of nums[i], nums[left], nums[right]
     * 7. If sum<0 then increment left pointer
     * 8. Else If sum>0 then decrement right pointer
     * 9. Else sum==0 then add the triplet to the list 
     * 10. before ending else we will check few things
     *      i while i < r we will check if nums[l] == tiplet[1] then we will l++
     *      ii while l < r we will check if nums[r] == tiplet[2] then we will r--
     * 
     *      we do this to avoid duplicates, such that there will be no [nums[i], nums[left], nums[right]] repeated again 
     * 11. return the list of triplets
     * 
     * Time Complexity: O(n^2)
     * 
     * 
     */
    public static List<List<Integer>> method1(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        if (arr.length < 3) {
            return res;
        }

        for (int i = 0; i < arr.length - 2; i++) {

            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = arr.length - 1;

            while (l < r) {
                int total = arr[i] + arr[l] + arr[r];
                if (total < 0) {
                    l++;
                } else if (total > 0) {
                    r--;
                } else {
                    List<Integer> triplet = Arrays.asList(arr[i], arr[l], arr[r]);
                    res.add(triplet);
                    while (l < r && arr[l] == triplet.get(1)) {
                        l++;
                    }
                    while (l < r && arr[r] == triplet.get(2)) {
                        r--;
                    }

                }
            }

        }
        return res;
    }


    /*
     * Set Approach 
     * 
     * Steps:
     * 
     * 1. Sort the array and create an Array to store list of triplets
     * 2. Initialize target as 0, List ans to store the triplets and Set to store the triplets
     * 3. Iterate through the input array only till nums.length-2 as we need 3 nums
     * 4. Initialize j=i+1 and k=nums.length-1 pointers, now are starting triplets are nums[i], nums[j], nums[k]
     * 5. while loop will run until j<k
     * 6. Calculate the sum of nums[i], nums[j], nums[k]
     * 7. If sum==0 then add the triplet to the set
     * 8. If sum<0 then increment j pointer
     * 9. Else If sum>0 then decrement k pointer
     * 10. Add the set to the list and return the list
     */
    public static List<List<Integer>> method2(int[] arr) {
        int target = 0;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        if (arr.length < 3) {
            return ans;
        }

        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) {
                    set.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        ans.addAll(set);
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = method2(arr);
        for (List<Integer> innerList : res) {
            for (Integer num : innerList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
