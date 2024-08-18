public class _1752_checkSortArr {
    public static void main(String[] args) {

        int nums[] = { 6, 4, 5, 1, 2, 3 };
        int l = nums.length;

        System.out.println(l);

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % l])
                count++;
        }

        if (count > 1) {
            System.out.println("Not sorted");
        } else {
            System.out.println("yes Sortedt");
        }
    }
}
