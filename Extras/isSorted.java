
public class isSorted {

    public static boolean isSorted(int[] arr, int index) {

        if (index == arr.length - 1) {
            return true;
        }

        if (arr[index] > arr[index + 1]) {
            return false;
        }

        return isSorted(arr, index + 1);
    }

    public static int sumArray(int[] arr, int index) {
        if (arr.length - 1 == index) {
            return arr[index];
        }

        return arr[index] + sumArray(arr, index+1);
    }

    public static int find(int[] arr, int i, int k){
        if(i==arr.length-1 && arr[i]!=k){
            return -1;
        }

        if(arr[i]==k){
            return i;
        }

        return find(arr, i+1, k);
    }



    public static void main(String[] args) {
        int[] arr1 = {1, 10, 3, 4, 5};

        System.out.println("Array 1 is sorted: " + isSorted(arr1, 0));

        System.out.println("Sum of array: " + sumArray(arr1, 0));

        System.out.println("Find " + 3 + " in array: " + find(arr1, 0, 3));
    }
}
