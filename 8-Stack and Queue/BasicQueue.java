public class BasicQueue {

    private int arr[];
    private int front; 
    private int rear;
    private int capacity;
    private int count;

    BasicQueue(int size){
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public Boolean isFull(){
        return (capacity == count);
    }

    public Boolean isEmpty(){
        return (count==0);
    }

    public void enqueue(int item){
        if(isFull()){
            System.out.println("Queue Overflow");
            System.exit(1);
        }

        rear =  (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue Underflow");
            System.exit(1);
        }

        int item = arr[front];
        front = (front + 1) % capacity;
        count--;

        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        return arr[front];
    }

    
    public int size() {
        return count;
    }

    public static void main(String[] args) {

        BasicQueue queue = new BasicQueue(5);
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Current size of queue: " + queue.size());

        System.out.println("Front element is: " + queue.peek());

        queue.dequeue();
        System.out.println("Front element after dequeue: " + queue.peek());

        System.out.println("Current size of queue: " + queue.size());
    
    }

}
