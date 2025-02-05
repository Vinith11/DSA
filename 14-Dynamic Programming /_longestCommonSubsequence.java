import java.util.Arrays;

public class _longestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text1.length()];

        for(char c: text2.toCharArray()){
            int currLength = 0;
            for(int i=0; i<dp.length; i++){
                if(dp[i]>currLength){
                    dp[i] = currLength; 
                } else if(c == text1.charAt(i)){
                    dp[i] = currLength + 1;
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
