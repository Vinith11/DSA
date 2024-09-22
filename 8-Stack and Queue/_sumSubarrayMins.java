
import java.util.*;
public class _sumSubarrayMins {

    // Brute Force
    public static int sumSubarrayMins1(int[] arr) {
        int MOD = (int) Math.pow(10, 9) + 7;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int min = getMin(arr, i, j);
                sum = (sum + min) % MOD;
            }
        }

        return sum;
    }

    private static int getMin(int[] arr, int start, int end) {
        int min = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            if (arr[i] < min)
                min = arr[i];
        }

        return min;
    }

    // Optimised Brute Force
    public static int sumSubarrayMins2(int[] arr) {
        int MOD = (int) Math.pow(10, 9) + 7;
        int min = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                }

                ans = (ans + min) % MOD;
            }
        }

        return ans;
    }

    // Monotonic stack
    public static int sumSubarrayMins3(int[] arr) {
        int MOD = (int) (1e9 + 7);
        long res = 0;
        Stack<int[]> stack = new Stack<>(); // Stack will store [index, num]

        // First loop: Traversing the array
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            while (!stack.isEmpty() && n < stack.peek()[1]) {
                int[] popped = stack.pop();
                int j = popped[0], m = popped[1];
                int left = (stack.isEmpty()) ? (j + 1) : (j - stack.peek()[0]);
                int right = i - j;
                res = (res + (long) m * left * right) % MOD;
            }
            stack.push(new int[] { i, n });
        }

        // Second loop: Processing remaining elements in the stack
        for (int i = 0; i < stack.size(); i++) {
            int[] current = stack.get(i);
            int j = current[0], n = current[1];
            int left = (i > 0) ? (j - stack.get(i - 1)[0]) : (j + 1);
            int right = arr.length - j;
            res = (res + (long) n * left * right) % MOD;
        }

        return (int) res;
    }

    // monotonic
    public static int sumSubarrayMins4(int[] A) {
        long res = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= A.length; i++) {
            while (!stack.isEmpty() && (i == A.length || A[stack.peek()] > A[i])) {
                int mid = stack.pop();
                int L = mid - (stack.isEmpty() ? -1 : stack.peek());
                int R = i - mid;
                res += (long) A[mid] * L * R;
            }
            stack.push(i);
        }
        return (int) (res % 1_000_000_007);
    }

    public int sumSubarrayMins5(int[] arr) {
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];

        Arrays.fill(left, -1);
        Arrays.fill(right, length);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int mod = (int) 1e9 + 7;
        long answer = 0;

        for (int i = 0; i < length; ++i) {
            answer += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            answer %= mod;
        }

        return (int) answer;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        System.out.println(sumSubarrayMins3(arr));
    }
}
