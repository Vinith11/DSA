import java.util.List;

public class _wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0]= true;

        for(int i=1; i<=s.length(); i++){
            for(String word:wordDict){
                int start = i - word.length();
                if(start>=0 && dp[start] && s.substring(start, i).equals(word)){
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
