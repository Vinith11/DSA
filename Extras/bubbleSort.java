
public class bubbleSort {


    public static void method1(int[] arr, int n) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length ; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void method2(int[] arr, int n ){
        if(n==0 || n==1){
            return;
        }
        
        //puts largest element at the end
        for (int i = 0; i < n-1; i++) {
            if(arr[i]>arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        method2(arr, n-1);
    }


    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        method2(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");

        }
    }
}
