public class QuickSort {



    static int[] quickSort(int[] arr, int l, int r){
        if(l<r){
            
            int pivot = partition(arr, l ,r);

            quickSort(arr, l, pivot-1);
            quickSort(arr, pivot+1, r);
        }

        return arr;
    }

    static int partition(int[] arr, int l, int r){
        int pivot = arr[l];
        int i=l;
        int j=r;

        while(i<j){
            while(arr[i]<=pivot && i<=r-1){
                i++;
            }

            while(arr[j]>pivot && j >= l+1){
                j--;
            }

            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
        return j;

    }




    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        arr = quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}