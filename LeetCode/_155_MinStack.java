
import java.util.Stack;


/*
 * Method1 - Single Stack
 */
 class Method1{

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

}

/*
 * Method2 - Two Stacks
 */
class Pair{
    int val, minVal;

    Pair(int val, int minVal){
        this.val = val;
        this.minVal = minVal;
    }
}

class Method2{
    Stack<Pair> stack = new Stack<>();

    public void push(int x){
        if(stack.isEmpty()){
            stack.push(new Pair(x, x));
        } else{
            int minVal = Math.min(x, stack.peek().minVal);
            stack.push(new Pair(x, minVal));
        }
    }

    public void pop(){
        stack.pop();
    }

    public int top(){
        Pair pair = stack.peek();
        return pair.val;
    }

    public int getMin(){
        Pair pair = stack.peek();
        return pair.minVal;
    }

}

public class _155_MinStack {
    

    public static void main(String[] args) {
        // Method1 minStack = new Method1();
        Method2 minStack = new Method2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}