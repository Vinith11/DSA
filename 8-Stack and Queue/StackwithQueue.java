
import java.util.LinkedList;
import java.util.Queue;

/*
 * Implement a stack using two queues.
 * 
 * The basic idea behind this code is q1 queue acts as stack and q2 will be acting a queue that accepts the elements.
 * We will push element in q2 and then move all elements from q1 to q2.
 * Then we will swap the q1 and q2. such that q1 will have the elements to be stack. and q2 is empty
 */
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (!q1.isEmpty()) {
            return q1.remove();
        }
        throw new IllegalStateException("Stack is empty");
    }

    public int top() {
        if (!q1.isEmpty()) {
            return q1.peek();
        }
        throw new IllegalStateException("Stack is empty");
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

class MyStack2 {
    Queue<Integer> q1;

    public MyStack2() {
        q1 = new LinkedList<>();
    }

    public void push(int x) {
        int size = q1.size();
        q1.add(x);
        while (size-- > 0) {
            q1.add(q1.poll());
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

public class StackwithQueue {
    public static void main(String[] args) {
        MyStack2 obj = new MyStack2();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
