
class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

public class _constructDLL {


    static Node constructDLL(int arr[]) {
        
        Node head = new Node(arr[0]);
        Node tail = head;

        for(int i=1; i<arr.length; i++){
            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        return head;
    }

    static void printDll(Node head){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = constructDLL(arr);
        printDll(head);
    }
}
