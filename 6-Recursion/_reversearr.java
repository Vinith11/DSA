
public class _reversearr {

    static void reversearr(int[] arr){
        int i = 0;
        int n = arr.length;
        recursive(i,n-1,arr);

    }

    static void recursive(int i, int n, int[] arr){
        if(i<n){
            int temp = arr[i];
            arr[i] = arr[n];
            arr[n] = temp;
            recursive(i+1, n-1, arr);
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        reversearr(arr);
        for(int i: arr){
            System.out.print( i + " ");
        }
    }
}
