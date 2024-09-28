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

public class _middleNode {

    public ListNode middleNode(ListNode head) {
        if(head.next == null)
            return head;

        ListNode temp = head;
        int count = 0;
        
        while(temp.next != null){
            count++;
            temp=temp.next;
        }

        count = (count+1)/2;

        while(count>0){
            head = head.next;
            count--;
        }

        return head;
        
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

        _middleNode obj = new _middleNode();
        ListNode res = obj.middleNode(head);

        travese(res);

    }
}