import java.io.*;
import java.lang.*;

class temp {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] strArr = str.split(" ");
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        for (int i = length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

    }

}