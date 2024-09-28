import java.util.*;

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

public class _detectCycle {
    
    public static ListNode detectCycle1(ListNode head) {
        if (head == null)
            return null;

        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;

        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            }
            map.put(temp, 1);
            temp = temp.next;
        }
        return null;
    }

    // optimised way
    public static ListNode detectCycle2(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == head){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
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

        travese(detectCycle(head));
    }
}
