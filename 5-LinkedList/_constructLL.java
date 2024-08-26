class Node {
    int data;
    Node next;

    // Node() {
    //     this.data = 0;
    //     this.next = null;
    // }

    Node(int d) {
        this.data = d;
        this.next = null;
    } 
}

public class _constructLL {
    
    static Node constructLL(int arr[]) {
        int n = arr.length;
        Node head = new Node(arr[0]);
        Node current = head;

        for(int i=1; i<n; i++){
            Node newNode = new Node(arr[i]);
            current.next = newNode;
            current = newNode;
        }

        return head;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        Node head = constructLL(arr);
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
