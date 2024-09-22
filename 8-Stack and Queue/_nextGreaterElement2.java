
import java.util.*;

public class _nextGreaterElement2 {
    public static int[] nextGreaterElement1(int[] nums) {
        int n=nums.length;
        Stack<Integer> stack= new Stack<>();
        int[] ans=new int[n];
        Arrays.fill(ans, -1); 

        for (int i = 2 * n - 1; i >= 0; i--) {
            int val = nums[i % n];
            while (!stack.isEmpty() && stack.peek() <= val)
                stack.pop();
            
            if(!stack.isEmpty() && i<n){
                ans[i]=stack.peek();
            }
            stack.push(nums[i%n]);
        }

        return ans;
    }  
    
    public static void main(String[] args) {
        int[] nums = { 100,1,11,1,120,111,123,1,-1,-100 };
        int[] ans = nextGreaterElement1(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
