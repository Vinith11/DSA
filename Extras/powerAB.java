
public class powerAB {

    public static int method1(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    public static int method2(int a, int b) {
        if (b == 0) {
            return 1;
        }

        if (b == 1) {
            return a;
        }

        /*
         * Suppose 2^10 = 2^5 * 2^5
         *         2^5 = 2^2 * 2^2 * 2
         *         2^2 = 2 * 2
         *         2^1 = 2
         *         2^0 = 1
         */
        int ans = method2(a, b / 2);

        if (b % 2 == 0) {
            return ans * ans;
        } else {
            return ans * ans * a;
        }

    }

    public static void main(String[] args) {
        System.out.println(method2(2, 10));
    }

}
