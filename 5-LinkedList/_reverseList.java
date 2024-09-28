class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}



public class _reverseList {

    public static ListNode reverseList(ListNode head) {

        ListNode prev= null;
        ListNode next= null;

        ListNode temp = head;

        while(temp != null){
            next = temp.next;
            temp.next = prev;

            prev = temp;
            temp = next;
        }
        return prev;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        //Base case
        if(head == null || head.next == null){
            return head;
        }

        //Recursive step
        // Reversing the node
        //this will make each node single and land at last node which will be the headz
        ListNode newHead = reverseListRecursive(head.next);

        ListNode front = head.next;
        front.next = head;
        
        head.next = null;
        

        return newHead;
    }

    public static void travese(ListNode head){
        ListNode current = head;

        if(current == null){
            System.out.println("LinkedList is empty");
            return;
        }

        while(current != null){
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(7);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode res = reverseListRecursive(head);

        travese(res);

    }
    
}
