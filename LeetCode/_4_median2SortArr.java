
import java.util.Arrays;

public class _4_median2SortArr {


    /*
     * Merge and sort
     * 
     * Steps:
     * 1. merge two arrays
     * 2. sort the merged array
     * 3. if n is even, return (n/2-1 + n/2)/2.0
     * 4. if n is odd, return n/2
     * 
     * Time Complexity:- worst case is O((n + m) * log(n + m)).
     */
    public static double method1(int[] arr1, int[] arr2) {

        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] merge = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            merge[i] = arr1[i];
        }

        for (int j = 0; j < n2; j++) {
            merge[n1 + j] = arr2[j];
        }

        Arrays.sort(merge);

        int n = merge.length;
        if (n % 2 == 0) {
            return (merge[n / 2 - 1] + merge[n / 2]) / 2.0;
        } else {
            return merge[n / 2];

        }
    }


    /*
     * Two-Pointer Method
     * 
     * 
     * 
     * 
     * Time Complexity:- O(n + m)
     */
    public static double method2(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int i =0, j=0, m1 =0, m2=0;

        // for median
        for(int count=0; count<=(n+m)/2; count++){
            m2 = m1;

            if(i!=n && j!=m){
                m1 = (arr1[i] > arr2[j]) ? arr2[j++] : arr1[i++];
            }else if(i<n){
                m1 = arr1[i++];
            }else{
                m1 = arr2[j++];
            }
        }

        // Check if the sum of n and m is odd.
        if ((n + m) % 2 == 1) {
            return (double) m1;
        } else {
            double ans = (double) m1 + (double) m2;
            return ans / 2.0;
        }

        
    }




    public static void main(String[] args) {
        int[] arr1 = {1, 3};
        int[] arr2 = {2};
        System.out.println(method2(arr1, arr2));
    }

}
