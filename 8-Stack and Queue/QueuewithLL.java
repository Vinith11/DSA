class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}

class MyQueue
{
    QueueNode front, rear;
    
    //Function to push an element into the queue.
	void push(int a)
	{
        if(front == null && rear == null){
            front = new QueueNode(a);
            rear = front;
        } else{
            QueueNode temp = new QueueNode(a);
            rear.next = temp;
            rear = temp;
        }
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        if(front == null){
            return -1;
        } else if(front.next != null){
            int r = front.data;
            front = front.next;
            return r;
        } else{
            int r = front.data;
            front = null;
            rear = null;
            return r;
        }
	}
}


public class QueuewithLL {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
}
