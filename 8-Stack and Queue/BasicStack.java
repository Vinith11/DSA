public class BasicStack {
    private int arr[];
    private int top;
    private int capacity;


    BasicStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }        
        return arr[top--];
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            System.exit(1);
        }
        return -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public static void main(String[] args) {

        BasicStack stack = new BasicStack(5);
        
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Current size of stack: " + stack.size());

        System.out.println("Top element is: " + stack.peek());

        stack.pop();
        System.out.println("Top element after pop: " + stack.peek());

        System.out.println("Current size of stack: " + stack.size());
   
    }

}
