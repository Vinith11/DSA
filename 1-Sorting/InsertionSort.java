
public class InsertionSort {

    /**
     * Takes an elemnt and places in correct postion
     * 
     * Steps of Insertion Sort:
     * 1. Iterate from arr[1] to arr[n] over the array.
     * 2. Compare the current element (key) to its predecessor.
     * 3. If the key element is smaller than its predecessor, compare it to the
     * elements before.
     * Move the greater elements one position up to make space for the swapped
     * element.
     * 4. Repeat until the array is sorted.
     */

    public static int[] insertionSort(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j>0; j--){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        arr = insertionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
