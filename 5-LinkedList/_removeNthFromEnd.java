
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

public class _removeNthFromEnd {
    public static void travese(ListNode head) {
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

    // Brute force
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        count -= n;
        temp = head;

        while (count > 1) {
            temp = temp.next;
            count--;
        }

        // if the ask the first element to be removed
        if (count == 0) {
            return head.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    // 2 pointer approach
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;


        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }


        slow.next = fast;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        travese(head);
        ListNode newHead = removeNthFromEnd2(head, 5);
        travese(newHead);
    }

}
