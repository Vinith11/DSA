public class _beautySum {
    public static int beautySum(String s) {
        int ans = 0;

        for(int i=0; i<s.length(); i++){
            int[] freq = new int[26];
            for(int j=i; j<s.length(); j++){
                freq[s.charAt(j) - 'a']++;

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                
                for(int k=0; k<freq.length; k++){
                    if(freq[k]>0){
                        min = Math.min(min, freq[k]);
                        max = Math.max(max, freq[k]);
                    }
                }
                ans += max-min;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(beautySum(s));
    }
}
