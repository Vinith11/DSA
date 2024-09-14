
import java.util.Stack;

public class _preToInfix {
    static String preToInfix(String pre_exp) {
        Stack<String> s = new Stack<>();

        for (int i = pre_exp.length() - 1; i >= 0; i--) {
            Character c = pre_exp.charAt(i);
            //if a Alpa or num is present we will directly push in stack
            if (Character.isLetterOrDigit(c)) {
                s.push(c + "");
            } else {
                // in else it will be and operand so we have to pop last 2 elements and add it between them
                String a = s.pop();
                String b = s.pop();
                String x = "(" + a + c + b + ")";

                s.push(x);
            }
        }

        return s.peek();
    }

    public static void main(String[] args) {
        String pre_exp = "*-A/BC-/AKL";
        System.out.println("Infix : " + preToInfix(pre_exp));
    }
}
