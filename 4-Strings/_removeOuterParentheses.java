public class _removeOuterParentheses {

    // 1. Start by initializing a count variable to 0 and an empty StringBuilder called ans.
    // 2. Iterate through each character, c, in the input string, s.
    // 3. If c is an opening parenthesis '(':
    //     a. If the count is not 0, append c to the ans StringBuilder.
    //     b. Increment the count by 1.
    // 4. If c is a closing parenthesis ')':
    //     a. If the count is greater than 1, append c to the ans StringBuilder.
    //     b. Decrement the count by 1.
    // 5. After iterating through all characters in s, return the ans StringBuilder as a string.
    // 6. In the main method, initialize a string variable, s, with the desired input.
    // 7. Call the removeOuterParentheses method with s as the argument and print the result.
    
    public static String removeOuterParentheses(String s) {        
        int count = 0;
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            if(c=='('){
                if(count != 0){
                    ans.append(c);
                }
                count++;
            } else{
                if(count > 1){
                    ans.append(c);
                }
                count--;
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

}
