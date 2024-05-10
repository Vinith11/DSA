
import java.util.Stack;

public class _739_DailyTemp {

    /*
     * Brute Force
     * 
     * Steps:
     * 1. Create a result array that contains n siize, Iterate through the array
     * 2. initaailize a flag to true, flag is used to check if the temperature is increasing or not
     * 3. Iterate through the array from i+1 to n
     * 4. If the temperature at j is greater than i, then store the difference between j index and i index in the result array, set the flag to false and break the loop
     * 5. If the flag is still true, then set the result array at i to 0
     * 6. Set the result array at n-1 to 0 as after last array element there is no temperature to compare
     * 7. return the result array
     * 
     * 
     * Time Complexity: O(n^2)
     */
    public static int[] method1(int[] t) {

        int[] res = new int[t.length];
        for (int i = 0; i < t.length - 1; i++) {
            Boolean flag = true;
            for (int j = i + 1; j < t.length; j++) {
                if (t[j] > t[i]) {
                    res[i] = j - i;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res[i] = 0;
            }
        }
        res[t.length - 1] = 0;

        return res;
    }

    /*
     * Using Stack
     * 
     * Steps:
     * 1. Create a stack to store the index of the temperature array and Create a result array to store the result
     * 2. Iterate through the array
     * 3. If the stack is not empty and the temperature at i is greater than the temperature at the index at the top of the stack,
     * 4. Then pop the stack and store the difference between i and the index at the top of the stack in the result array
     * 5. Continue the loop until the stack is empty or the temperature at i is less than the temperature at the index at the top of the stack
     * 6. Push the index i to the stack
     * 
     * Time Complexity: O(n)
     */
    public static int[] method2(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length]; //initialize the result array with 0F

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = method2(T);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
