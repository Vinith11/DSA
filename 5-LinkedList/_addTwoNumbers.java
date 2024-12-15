class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class _addTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode temp = res;

        int total = 0, carry = 0;

        while(l1 != null || l2 != null || carry !=0){
            total = carry;

            if(l1!=null){
                total += l1.val;
                l1 = l1.next;
            }

            if(l2!=null){
                total += l2.val;
                l2 = l2.next;
            }

            int num = total % 10; 
            carry = total / 10;
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        return res.next;
    }
    

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next(new ListNode(4));

        ListNode l2 = new ListNode(2);
        l2.next(new ListNode(4));

        
        
    }
}
