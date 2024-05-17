
import java.util.*;

public class _131_PalindromePartioning{

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(s, 0, path, res);
        return res;
    }
    
    private void dfs(String s, int index, List<String> path, List<List<String>> res){
        if(index == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i + 1));
                dfs(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        _131_PalindromePartioning pp = new _131_PalindromePartioning();
        List<List<String>> res = pp.partition("aab");
        for(List<String> list : res){
            System.out.println(list);
        }
    }
}