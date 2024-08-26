class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class _getCount{

    public static int getCount(Node head) {
        int count = 0;
        Node current = head;

        while(current != null){
            count++;
            current = current.next;
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};

        _getCount count = new _getCount();

        Node head = new Node(arr[0]);

        Node current = head;

        for(int i=1; i<arr.length; i++){
            Node newNode = new Node(arr[i]);
            current.next = newNode;
            current = newNode;
        }

        System.out.println(getCount(head));
    }
}