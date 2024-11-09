/**
 * Bubble Sort Algorithm:
 * 1. Iterate over the array from the beginning to the end.
 * 2. For each element in the array, compare it with the next element.
 * 3. If the current element is greater than the next element, swap them.
 * 4. Repeat steps 1-3 for all elements in the array.
 * 5. Continue the process until the array is sorted (no swaps are needed in a
 * complete pass).
 *
 * This algorithm has a time complexity of O(n^2) in the worst and average
 * cases, and O(n) in the best case when the array is already sorted.
 * It is a simple but inefficient sorting algorithm for large datasets.
 */
public class BubbleSort {

    static int[] bubbleSort1(int[] arr) {
        int n = arr.length;

        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    /*
     * This is the optimized way to reduse number of times the array is iterarted
     * 
     * didSwap stores number of times no. is being swapped
     */
    static int[] bubbleSort2(int[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            int didSwap = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    didSwap = 1;
                }
            }
            if (didSwap == 0) {
                break;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        arr = bubbleSort1(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
