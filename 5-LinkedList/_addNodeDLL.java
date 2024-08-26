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

public class _addNodeDLL {

    static Node constructDLL(int arr[]){
        Node head = new Node(arr[0]);
        Node tail = head;

        for(int i =1; i<arr.length; i++){
            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            newNode.prev = tail;
            tail=newNode;
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

    static void addNode(Node head_ref, int pos, int data)
	{
        Node current = head_ref;

		while(pos != 0){
            current = current.next;
            pos--;
        }
        Node newNode = new Node(data);

        if(current.next == null){
            newNode.next = null;
            newNode.prev = current;
            current.next = newNode;
        } else{
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
	}

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        Node head = constructDLL(arr);
        printDll(head);

        System.out.println("\n");
        addNode(head, 3, 99);
        printDll(head);
    }
}
