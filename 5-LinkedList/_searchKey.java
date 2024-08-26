class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class _searchKey {

    static boolean searchKey(int n, Node head, int key) {
        if(head == null) return false;

        Node current = head;

        while(current != null){
            if(current.data == key){
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        Node head = new Node(arr[0]);
        Node current = head;

        for(int i=1; i< arr.length; i++){
            Node newNode = new Node(arr[i]);
            current.next = newNode;
            current = newNode;
        }

        System.out.println(searchKey(arr.length, head, 4));
    }
}
