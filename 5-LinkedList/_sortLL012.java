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


public class _sortLL012 {

    // rearrange the linked list such that all 0s are followed by all 1s and all 1s are followed by all 2s
    public static ListNode sortList1(ListNode head){
        ListNode zero = new ListNode(0);
        ListNode one = new ListNode(0);
        ListNode two = new ListNode(0);

        ListNode zeroHead = zero;
        ListNode zeroTail = zero;

        ListNode oneHead = one;
        ListNode oneTail = one;

        ListNode twoHead = two;
        ListNode twoTail = two;

        ListNode current = head;

        while(current != null){
            if(current.val == 0){
                zeroTail.next = current;
                zeroTail = zeroTail.next;
            }else if(current.val == 1){
                oneTail.next = current;
                oneTail = oneTail.next;
            }else{
                twoTail.next = current;
                twoTail = twoTail.next;
            }
            current = current.next;
        }

        zeroTail.next = oneHead.next;
        oneTail.next = twoHead.next;
        twoTail.next = null;

        return zeroHead.next;
    }

    // replaceing the values
    public static ListNode sortList2(ListNode head){
        int[] count = new int[3];
        ListNode current = head;

        while(current != null){
            count[current.val]++;
            current = current.next;
        }

        current = head;
        
        while(current != null){
            if(count[0] > 0){
                current.val = 0;
                count[0]--;
            }else if(count[1] > 0){
                current.val = 1;
                count[1]--;
            }else{
                current.val = 2;
                count[2]--;
            }
            current = current.next;
        }

        return head;
    }


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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(2);

        travese(head);
        head = sortList2(head);
        travese(head);
    }
    
}
