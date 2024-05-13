
public class digitToStr {

    public static void method1(int n, String[] map) {
        if (n == 0) {
            // System.out.println(map[n]);
            return;
        }

        int digit = n % 10;
        n = n / 10;
        method1(n, map);
        System.out.println(map[digit]);


    }

    public static void main(String[] args) {
        String[] map = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        method1(412, map);
        
    }
}
