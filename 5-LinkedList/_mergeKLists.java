public class _mergeKLists {
    public ListNode mergeKLists1(ListNode[] list) {

        if(list.length == 0 || list == null){
            return null;
        } else if(list.length == 1){
            return list[0];
        } else if(list.length == 2){
            return mergeTwoLists(list[0], list[1]);
        }

        ListNode ans = mergeTwoLists(list[0], list[1]);
        for(int i=2; i<list.length; i++){
            ans = mergeTwoLists(ans,list[i]);
        }
       
        return ans;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;

        ListNode ans = new ListNode();
        ListNode tail = ans;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        if (head1 != null) {
            tail.next = head1;
        }

        if (head2 != null) {
            tail.next = head2;
        }

        return ans.next;
    }

    public ListNode mergeKLists2(ListNode[] list) {

        if(list.length == 0 || list == null){
            return null;
        } 
        return mergeHelper(list, 0, list.length-1);
    }

    public ListNode mergeHelper(ListNode[] list, int l, int h){
        if(l == h){
            return list[l];
        } else if(l+1 == h){
            return mergeTwoLists(list[l], list[h]);
        }

        int m = l + (h-l)/2;
        ListNode left = mergeHelper(list, l, m);
        ListNode right = mergeHelper(list, m+1, h);

        return mergeTwoLists(left, right);
    }
}
