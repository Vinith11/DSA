
import java.util.*;

public class _20_vallidParam {

    /*
     * Hashmap and Stack
     * 
     * Steps:
     * 1. Create a stack and a hashmap, In Hashmap, put closing brackets as key and
     * opening brackets as value.
     * 2. Iterate through the string, if the character is an opening bracket, push
     * it to the stack.
     * 3. if it is a closing bracket, check if the stack is empty or the top of the
     * stack is not the corresponding opening bracket, return false.
     * 4. If the stack is empty at the end, return true.
     * 
     * Time complexity: O(n)
     */
    public static Boolean method1(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                stack.push(c);
            } else if (map.containsKey(c)) {
                if (stack.isEmpty() || map.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    /*
     * Stack
     * 
     * Steps:
     * 1. Create a stack, iterate through the string.
     * 2. If the stack is not empty, check if the top of the stack and the current
     * character is a pair, if yes, pop the top of the stack.
     * 3. If not, push the character to the stack.
     * 
     * 
     * Time complexity: O(n)
     */
    public static Boolean method2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char last = stack.peek();
                if (isPair(last, c)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }

    private static Boolean isPair(char last, char c) {
        return (last == '(' && c == ')') || (last == '[' && c == ']') || (last == '{' && c == '}');
    }

    public static Boolean temp(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty() && isPair(stack.peek(), c)) {
                stack.pop()
                continue;
            } 
            stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[]";
        System.out.println(temp(s));
    }
}
