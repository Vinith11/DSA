public class _rmDuplicateSortarr {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 5, 5, 6, 6, 7, 8, 9, 9 };
        
        int i = 0;
        int j = 1;
   
        while(j<arr.length){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
            j++;
        }

        System.out.println(i+1);

    }
}
