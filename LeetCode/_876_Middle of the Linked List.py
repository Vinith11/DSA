# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def middleNode(self, head):
        l=[]
        h=head
        while(head):
            l.append(head.val)
            head=head.next

        m=0
        if(len(l)%2==0):
            m=(len(l)/2)+1
        else:
            m=len(l)/2

        c=0
        while(c<m):
            h=h.next
            c+=1

        return h

        
        
