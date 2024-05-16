
import java.util.*;

public class _17_LetterCombo{

    List<String> ans = null;
    String [] strMap = {"0","1","abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
            
        backtrack(0,digits, new StringBuilder());
        return ans;
    }

    void backtrack(int index, String digits, StringBuilder temp){

        if(index>= digits.length()){
            ans.add(temp.toString());
            return;
        }

        char ch = digits.charAt(index);
        String str = strMap[ch - '0'];

        for(char c:str.toCharArray()){
            temp.append(c);
            backtrack(index+1,digits, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static void main(String[] args) {
        _17_LetterCombo lc = new _17_LetterCombo();
        System.out.println(lc.letterCombinations("23"));
    }
}