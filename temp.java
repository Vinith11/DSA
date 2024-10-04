import java.io.*;
import java.lang.*;

public class temp {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int a = Integer.parseInt(br.readLine());
            double b = Double.parseDouble(br.readLine());
            boolean c = Boolean.parseBoolean(br.readLine());
            String d = br.readLine();

            System.out.println("Now array in spaces");
            String str = br.readLine();

            String[] arrStr =  str.split(" ");
            
            int[] arr = new int[arrStr.length];
            for(int i=0; i<arrStr.length; i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }

            System.out.println("Now array is printing");
            for(int i: arr){
                System.out.print(i + " ");
            }
            System.out.println();

            System.out.println("This is Int: " + a);
            System.out.println("This is Double: " + b);
            System.out.println("This is boolean: " + c);
            System.out.println("This is String: " + d);

        } catch (IOException e) {
            System.out.println(e);
        }

        
    }
}
