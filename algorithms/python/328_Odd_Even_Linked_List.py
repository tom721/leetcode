# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        if head is None:
            return head
        
        odd = head
        even = head.next
        p_even = even
        
        while even and even.next:
            odd.next, even.next = even.next, even.next.next
            odd,even = odd.next, even.next
        
        odd.next = p_even
        return head