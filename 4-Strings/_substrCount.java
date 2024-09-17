public class _substrCount {

    static long substrCount(String S, int k) {

        int n = S.length();

        long res = 0;

        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            int dist_count = 0;

            // substing b/w [i..j]
            for (int j = i; j < n; j++) {

                // if this is a new character for sub string increnet dist_count
                if (count[S.charAt(j) - 'a'] == 0) {
                    dist_count++;
                }

                // increment count of current character
                count[S.charAt(j) - 'a']++;

                if (dist_count == k) {
                    res++;
                }

                if (dist_count > k) {
                    break;
                }

            }
        }
        return res;

    }

    /*
     * static long substrCount2 (String s, int k) {
     * 
     * if(k<0) return 0;
     * 
     * int i =0, j=0, count =0;
     * long res = 0;
     * int[] hash = new int[26];
     * 
     * while (j<s.length()) {
     * //increment freq of current character
     * hash[(int)(s.charAt(j) - 'a')]++;
     * 
     * // if freq brcomes 1, increase the count
     * if (hash[(int)(s.charAt(j) - 'a')] == 1) count++;
     * 
     * //if count is greater than k
     * while (count > k) {
     * hash[(int)(s.charAt(i)-'a')]--;
     * 
     * 
     * }
     * 
     * }
     * 
     * }
     */

    public static void main(String[] args) {
        String str = "aba";
        int K = 2;
        System.out.println(substrCount(str, K));
    }
}
