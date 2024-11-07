
import java.util.Scanner;

public class _bitToNum {

    public static int bitToNum(String bit) {
        int len = bit.length();
        int power2 = 1;
        int ans = 0;

        for (int i = bit.length() - 1; i >= 0; i--) {
            if (bit.charAt(i) == '1') {
                ans += power2;
            }
            power2 *= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner var1 = new Scanner(System.in);
        System.out.print("Enter number: ");
        String var2 = var1.nextLine();
        System.out.println("Bit value: " + bitToNum(var2));
    }
}
