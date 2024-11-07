public class _oddeven {
    static String oddEven(int n) {
        return (n & 1) == 1 ? "Odd" : "Even";
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Is " + n + " odd or even? " + oddEven(n));
    }

}
