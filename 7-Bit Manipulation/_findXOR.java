public class _findXOR {

    // N XOR
    // 1 -> 1 = 1
    // 2 -> 1^2 = 3
    // 3 -> 1^2^3 = 0
    // 4 -> 1^2^3^4 = 4

    // 5 -> 1^2^3^4^5 = 1
    // 6 -> 1^2^3^4^5^6 = 7
    // 7 -> 1^2^3^4^5^6^7 = 0
    // 8 -> 1^2^3^4^5^6^7^8 = 8

    // 9 -> 1^2^3^4^5^6^7^8^9 = 1
    // 10 -> 1^2^3^4^5^6^7^8^9^10 = 11
    // 11 -> 1^2^3^4^5^6^7^8^9^10^11 = 0
    // 12 -> 1^2^3^4^5^6^7^8^9^10^11^12 = 12

    public static int bit(int n) {
        if (n % 4 == 0) {
            return n;
        } else if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n + 1;
        }

        return 0;
    }

    public static int findXOR(int l, int r) {

        return bit(l - 1) ^ bit(r);
    }

    public static void main(String[] args) {
        int l = 5, r = 8;
        System.out.println("XOR of all numbers in range from " + l + " to " + r + " is " + findXOR(l, r));
    }
}
