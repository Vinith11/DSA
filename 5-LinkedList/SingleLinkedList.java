import java.util.Scanner;


class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{

    Node head;

    LinkedList(){
        this.head = null;
    }

    //traversal and print
    public void travese(){
        Node current = head;

        if(current == null){
            System.out.println("LinkedList is empty");
            return;
        }

        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("\n");
    }

    //insert at the end
    public void insert(int data){
        Node newNode = new Node(data);

        if(head==null){
            head = newNode;
            return;
        }

        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;

        System.out.println("Inserted " + data + " at the end");
    }

    // delete a node by value
    public void delete(int key){
        Node current = head;
        Node prev = null;

        //if key is head value
        if(current != null && current.data == key){
            head = current.next;
            return;
        }

        while(current != null && current.data != key){
            prev = current;
            current = current.next;
        }

        if(current == null){
            System.out.println("Key not found");
            return;
        }

        //unlink the node
        prev.next = current.next;
    }

        // Method to find the length of the LinkedList
        public int length() {
            int count = 0;
            Node current = head;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }
    
        // Method to search for an element in the LinkedList
        public boolean search(int key) {
            Node current = head;
            while (current != null) {
                if (current.data == key) return true;
                current = current.next;
            }
            return false;
        }

}



public class SingleLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose an operation:");
            System.out.println("1. Insert at the end");
            System.out.println("2. View the LinkedList");
            System.out.println("3. Delete a node by value");
            System.out.println("4. Find the length of the LinkedList");
            System.out.println("5. Search for an element in the LinkedList");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert: ");
                    int insertValue = scanner.nextInt();
                    linkedList.insert(insertValue);
                    break;
                case 2:
                    System.out.println("The LinkedList is:");
                    linkedList.travese();
                    break;
                case 3:
                    System.out.print("Enter the value to delete: ");
                    int deleteValue = scanner.nextInt();
                    linkedList.delete(deleteValue);
                    break;
                case 4:
                    int length = linkedList.length();
                    System.out.println("Length of the LinkedList: " + length);
                    break;
                case 5:
                    System.out.print("Enter the value to search: ");
                    int searchValue = scanner.nextInt();
                    boolean found = linkedList.search(searchValue);
                    if (found) {
                        System.out.println("Element found in the LinkedList");
                    } else {
                        System.out.println("Element not found in the LinkedList");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }
}
