import java.io.*;
import java.util.*;

public class temp {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        int target = Integer.parseInt(br.readLine());
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Target found at index: " + i);
                break;
            } else if( i == arr.length - 1) {
                System.out.println("Target not found");
            }
        }
        

        Arrays.fill(arr, 1);
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, 3)));

        int[] arr2 = Arrays.copyOfRange(arr, 0, 3);
        System.out.println(Arrays.toString(arr2));
    }
}