public class SelectionSort {

    /*
     * Selection Sort
     * 
     * We first find the minimum and then swap the smallest elements with subbaray 
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
        
        int n = arr.length;
        
        for(int i=0; i<n-1; i++){
            int min = i;
            for(int j=i+1; j<n; j++){
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
