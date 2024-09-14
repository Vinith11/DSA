class MyStack {
    class StackNode {
        int data;
        StackNode next;
        StackNode(int a) {
            data = a;
            next = null;
        }
    }
    StackNode top;

    /*
     * New node is created and its next is referenced to the top node.
     * Then the top is updated to the new node.
     */
    void push(int a) {
        if(top == null){
            top = new StackNode(a);
        } else{
            StackNode temp = new StackNode(a);
            temp.next = top;
            top = temp;
        }
        
    }

    /*
     * If the top is null, then return -1.
     * 
     * Else, create a temp node and assign it to top.
     * Then update the top to the next node.
     */
    int pop() {
        if(top == null){
            return -1;
        } else{
            int r = top.data;
            top = top.next;
            
                    
            return r;
        }
    }
}


public class StackwithLL {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
}
