
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class _insertAtEnd {

    Node head;

    public _insertAtEnd() {
        this.head = null;
    }

    Node insertAtEnd(Node head, int x) {

        if (head == null) {
            return new Node(x);
        }

        Node newNode = new Node(x);

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        return head;
    }

    // traversal and print
    public void travese() {
        Node current = head;

        if (current == null) {
            System.out.println("LinkedList is empty");
            return;
        }

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        _insertAtEnd list = new _insertAtEnd();
        list.head = list.insertAtEnd(list.head, 1);
        list.head = list.insertAtEnd(list.head, 2);
        list.head = list.insertAtEnd(list.head, 3);

        list.travese();
    }
}
