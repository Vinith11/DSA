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

public class _reverseDLL {

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
        System.out.println();  // For better output formatting
    }

    public static Node reverseDLL(Node head) {
        Node current = head;
        Node prev = null;

        // Traverse the list and swap next and prev for each node
        while (current != null) {
            prev = current.prev;

            // Swap the next and prev pointers
            current.prev = current.next;
            current.next = prev;

            // Move to the next node (which is now the previous node)
            current = current.prev;
        }
        
        // After the loop, prev points to the original first node
        // The new head of the reversed list is prev.prev (which is the original last node)
        if (prev != null) {
            head = prev.prev;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4};
        Node head = constructDLL(arr);
        System.out.print("Original DLL: ");
        printDll(head);

        head = reverseDLL(head);
        System.out.print("Reversed DLL: ");
        printDll(head);
    }
}
