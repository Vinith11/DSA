
import java.util.Stack;


/*
 * Implement a queue using two stacks.
 * 
 * The idea here is s1 will be main stac s2 will be temporary stack.
 * Before pushing the element to s1 we will move all elements from s1 to s2.
 * Then we will push the element to s1 and then move all elements from s2 to s1.
 */
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}



public class QueuewithStack {
    public static void main(String[] args) {
        
    }
}
