
import java.util.Stack;

public class _postToPre {
    static String postToPre(String post_exp) {
        Stack<String> s = new Stack<>();

        for(int i =0; i<post_exp.length(); i++){
            Character c = post_exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                s.push(c + "");
            } else{
                String op1 = s.pop();
                String op2 = s.pop();
                String x = c + op2 + op1;

                s.push(x);
            }
        }

        return s.peek();
    }

    public static void main(String[] args) {
        String s = "ABC/-AK/L-*";
        System.out.println(postToPre(s));
    }
}
