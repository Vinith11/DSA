

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

public class _sortList {

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


    public static ListNode middleNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    
    public static ListNode sortList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode middle = middleNode(head);
        ListNode nextToMiddle = middle.next;
        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(nextToMiddle);

        return merge(left, right);
    }

    public static ListNode merge(ListNode left, ListNode right){
        ListNode result = new ListNode();
        ListNode current = result;

        while(left != null && right != null){
            if(left.val < right.val){
                current.next = left;
                left = left.next;
            }else{
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if(left != null){
            current.next = left;
        }

        if(right != null){
            current.next = right;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(0);

        travese(head);

        ListNode newHead = sortList(head);
        travese(newHead);
    }

}
