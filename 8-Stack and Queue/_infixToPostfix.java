
import java.util.Stack;

public class _infixToPostfix {

    static int precedence(char c) {
        if (c == '^') {
            return 3;
        } else if (c == '/' || c == '*') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return -1;
        }
    }

    public static String infixToPostfix(String exp) {
        Stack<Character> s = new Stack<>();

        String result = "";

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                // all num or char will be inserted
                result += c;
            } else if (c == '(') {
                s.push(c);
            } else if (c == ')') {
                // pop and add in main string until '(' is encountered and then pop '(' too
                while (!s.isEmpty() && s.peek() != '(') {
                    result += s.pop();
                }
                s.pop();
            } else {
                // at top of stack only highest precendce value can stay if lower precencde char comes then pop element 
                // until the current element becomes the highest precedene 
                while (!s.empty() && precedence(c) <= precedence(s.peek())) {
                    result += s.pop();
                }
                s.push(c);
            }
        }

        // pop all remaining elements
        while (!s.empty()) {
            result += s.peek();
            s.pop();
        }

        return result;

    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }
}
