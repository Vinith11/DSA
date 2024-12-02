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



public class _mergeTwoLists {
    

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head1 = list1;
        ListNode head2 = list2;
        
        ListNode ans = new ListNode();
        ListNode tail = ans;


        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                tail.next = head1;
                head1=head1.next;
            } else{
                tail.next = head2;
                head2=head2.next;
            }

            tail=tail.next;
        }

        if(head1!=null){
            tail.next = head1;
        }

        if(head2!=null){
            tail.next = head2;
        }

        return ans.next;
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

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(7);

        ListNode ans = mergeTwoLists(head, head2);
        while(ans!=null){
            System.err.println(ans.val);
            ans = ans.next;
        }
    }
}
