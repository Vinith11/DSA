public class SelectionSort {

    /*
     * Selection Sort
     * 
     * We find minimum and then swap the elements
     *
     * It has an O(n^2) time complexity,
     * 
     * Steps for selection sort:
     * 1. Iterate over the array from the first to the second-to-last element.
     * 2. For each position, find the smallest element in the unsorted portion of
     * the array.
     * 3. Swap the smallest element found with the element at the current position.
     * 4. Repeat until the entire array is sorted.
     */

     public static int[] selectionSort(int[] arr){
        for(int i=0; i<= arr.length-2; i++){
            int min = i;
            for(int j=i; j<arr.length; j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }
    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        arr = selectionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
