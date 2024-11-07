public class _countSetBits {

    public static int countBits(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int countSetBits(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans += countBits(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 17;
        System.out.println("Number of set bits in " + n + " are " + countSetBits(n));
    }
}
