

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

public class _oddEvenList {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode oddHead = new ListNode(0);
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode(0);
        ListNode evenTail = evenHead;

        int count = 1;

        while(head != null){

            if(count % 2 == 0){
                evenTail.next = head;
                evenTail = evenTail.next;
            }else{
                oddTail.next = head;
                oddTail = oddTail.next;
            }
            head = head.next;
            count++;
        }
        evenTail.next = null;
        oddTail.next = evenHead.next;

        return oddHead.next;
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

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        
        ListNode result = oddEvenList(head);

        travese(result);

    }
}
