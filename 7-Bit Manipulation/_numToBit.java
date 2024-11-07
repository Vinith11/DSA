
import java.util.Scanner;

public class _numToBit {

    public static String numToBit(int a) {
        String bit = "";
        while (a > 0) {
            bit = (a % 2) + bit;
            a = a / 2;
        }
        return bit;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int a = sc.nextInt();
        System.out.println("Bit value: " + numToBit(a));
    }
}
