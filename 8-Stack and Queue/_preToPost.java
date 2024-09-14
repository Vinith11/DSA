
import java.util.Stack;

public class _preToPost {
    static String preToPost(String pre_exp) {
        Stack<String> s = new Stack<>();

        for(int i = pre_exp.length()-1; i>=0; i--){
            Character c = pre_exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                s.push(c + "");
            } else{
                String op1 = s.pop();
                String op2 = s.pop();
                String x = op1 + op2 + c;

                s.push(x);
            }
        }

        return s.peek();
    }

    public static void main(String[] args) {
        String s = "*-A/BC-/AKL";
        System.out.println(preToPost(s));
    }
}
