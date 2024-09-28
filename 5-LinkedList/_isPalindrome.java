
import java.util.Stack;

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

public class _isPalindrome {
   
    
    // Stack method
    public static boolean isPalindrome1(ListNode head) {
        Stack<Integer> s = new Stack<>();

        ListNode temp = head;

        while (temp != null) {
            s.push(temp.val); 
            temp = temp.next;   
        }

        temp = head;

        while(!s.isEmpty()){
            if(temp.val != s.pop()){
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

    //optimised way
    public static boolean isPalindrome2(ListNode head) {
        Stack<Integer> s = new Stack<>();

        ListNode temp = head;

        while (temp != null) {
            s.push(temp.val); 
            temp = temp.next;   
        }

        temp = head;

        while(!s.isEmpty()){
            if(temp.val != s.pop()){
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

    
    public static void main(String[] args) {
        // Create a linked list with
        // values 1, 5, 2, 5, and 1 (15251, a palindrome)
        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);


        // Check if the linked list is a palindrome
        if (isPalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
