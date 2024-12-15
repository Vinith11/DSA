class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


public class _copyRandomList{

    public Node copyRandomList1(Node head) {

        if(head == null)
            return null;

        // iterate nodes
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers
        curr = head;
        while( curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Seprate lists
        curr = head;
        Node copyHead= head.next;
        Node copyCurr = copyHead;
        while( curr != null){
            curr.next = curr.next.next;
            if(copyCurr.next != null){
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;        
    }


}