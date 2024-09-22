
import java.util.Stack;

public class _asteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            if (asteroids[i] > 0) {
                s.push(asteroids[i]);
            } else {
                // if the -ve i.e astroid that will be coliding is larger than top element,
                // then it will be destroyed so we will pop all emenents that are smaller than it
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < -asteroids[i]) {
                    s.pop();
                } 
                // an -ve to pass without collision
                if(s.isEmpty() || s.peek() < 0){
                    s.push(asteroids[i]);
                }
                // if collison asteroid and top asteroid is same then both will be destroyed
                if(s.peek() == -asteroids[i]){
                    s.pop();
                }

            }
        }

        int[] ans = new int[s.size()];
        int j = s.size() - 1;

        while (!s.isEmpty()) {
            ans[j--] = s.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        // int[] asteroids = { 5, 10, -5, -1 };
        int[] asteroids = { 10,-5, -1, 10 };
        int[] ans = asteroidCollision(asteroids);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
