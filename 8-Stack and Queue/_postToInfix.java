
import java.util.Stack;

public class _postToInfix{
    static String postToInfix(String exp) {
        Stack<String> s = new Stack<>();
        for(int i =0; i< exp.length(); i++){
            Character c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                s.push(c + "");
            } else{
                String op1 = s.pop();
                String op2 = s.pop();
                String x = "("  + op2 + c + op1 + ")";

                s.push(x);
            }
        }

        return s.peek();
    }


    public static void main(String[] args) {
        String s = "ab*c+";
        System.err.println(postToInfix(s));
    }
}