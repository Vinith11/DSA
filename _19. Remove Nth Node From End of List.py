# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        o=t=head
        r=0
        while(r<n):
            t=t.next
            r+=1
        if not t:
            return head.next

        while t.next:
            o=o.next
            t=t.next

        o.next=o.next.next
        return head
            