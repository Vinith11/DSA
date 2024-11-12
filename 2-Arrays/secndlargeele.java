import java.lang.*;
import java.util.*;

public class secndlargeele {
    
    public static int secondLarge(int[] arr){
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(a<arr[i]){
                b=a;
                a=arr[i];
            } else if(a>arr[i] && b<arr[i]){
                b = arr[i];
            }
        }

        return b;
    }

    public static void main(String[] args) {
        int[] arr = {5,6,3,2,1};

        System.out.println(secondLarge(arr));
    }
}
