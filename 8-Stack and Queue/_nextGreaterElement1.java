import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class _nextGreaterElement1 {
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        int found = 0;
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums1.length; i++) {
            found = 0;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    found = 1;
                }
                if (nums1[i] < nums2[j] && found == 1) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }

        return ans;
    }

    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums2[i] >= s.peek()) {
                s.pop();
            }
            if (s.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], s.peek());
            }
            s.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    public static int[] nextGreaterElement3(int[] nums1, int[] nums2) {

        int[] stack = new int[1001];
        // The underscore (_) is used in numeric literals in Java to make large numbers more readable. 
        // this is 10,001 size array
        int[] map = new int[10_001];

        int top = -1;
        for (int i = nums2.length - 1; i >= 0; i--) {
            int val = nums2[i];
            while (top >= 0 && stack[top] <= val)
                top--;
            map[val] = (top == -1) ? -1 : stack[top];
            stack[++top] = val;
        }
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map[nums1[i]];
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        int[] ans = nextGreaterElement2(nums1, nums2);
        for (int i : ans) {
            System.out.print(i + " ");
        }

    }
}
