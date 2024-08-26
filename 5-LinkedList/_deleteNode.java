
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class _deleteNode {
    ListNode head;

    public _deleteNode() {
        this.head = null;
    }

    ListNode insertAtEnd(ListNode head, int x) {

        if (head == null) {
            return new ListNode(x);
        }
        ListNode newNode = new ListNode(x);
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

        return head;
    }

    // traversal and print
    public void travese() {
        ListNode current = head;

        if (current == null) {
            System.out.println("LinkedList is empty");
            return;
        }

        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("\n");
    }

    //delete Node
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }

    public static void main(String[] args) {
        _deleteNode list = new _deleteNode();
        list.head = list.insertAtEnd(list.head, 1);
        list.head = list.insertAtEnd(list.head, 2);
        list.head = list.insertAtEnd(list.head, 3);
        list.head = list.insertAtEnd(list.head, 4);
        list.head = list.insertAtEnd(list.head, 5);
        list.head = list.insertAtEnd(list.head, 6);

        list.travese();

        list.deleteNode(head);

        list.travese();

    }
}
