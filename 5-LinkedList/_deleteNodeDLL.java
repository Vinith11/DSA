class Node {
    int data;
    Node prev;
    Node next;

    Node(int x) {
        data = x;
        prev = null;
        next = null;
    }
}

public class _deleteNodeDLL {

    Node head = null;

    static Node constructDLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node tail = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        return head;
    }

    static void printDll(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static Node deleteNode(Node head, int x) {
        Node current = head;

        x = x - 1;

        while (x-- > 0) {
            current = current.next;
        }
        
        if (head == null || current == null) return null;
        
        if(head == current){
            head = current.next;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }

        return head; 
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4 };
        Node head = constructDLL(arr);
        printDll(head);

        System.out.println("\n");

        head = deleteNode(head, 3);
        printDll(head);
    }

}
