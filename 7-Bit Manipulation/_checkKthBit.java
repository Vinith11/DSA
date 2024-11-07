public class _checkKthBit {

    static boolean checkKthBit(int n, int k) {
        return ((n & (1 << (k))) != 0);
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        System.out.println("Is " + k + "th bit set in " + n + "? " + checkKthBit(n, k));
    }
    
}
