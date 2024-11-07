public class _isPowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        return (n & (n-1)) == 0? true : false;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Is " + n + " a power of 2? " + isPowerOfTwo(n));
    }

}
