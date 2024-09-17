
public class MergeSort {
    
    static void merge(int[] arr, int l, int m, int r){
        // size of sub array
        int n1 = m - l + 1;
        int n2 = r - m;

        //size of temp array
        int L[] = new int[n1];
        int R[] = new int[n2];

        //copy data from main array
        for(int i=0; i<n1; ++i){
            L[i] = arr[l+i];
        }
        for(int j=0; j<n2; ++j){
            R[j] = arr[m+1+j];
        }

        int i =0, j = 0;

        //intial index of sub - array
        int k=l; 
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
            } else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //coping remaining elements
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }



    }
    
    public static int[] mergeSort(int[] arr, int l, int r){
        if(l<r){
            int m = l + (r - l)/2;

            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);

            merge(arr, l, m, r);
        }

        return arr;
    }



    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        arr = mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
