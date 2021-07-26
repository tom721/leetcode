# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        answer = ListNode(-101)
        search = answer
            
        while l1 is not None or l2 is not None:
            if l1 is None:
                search.val  = l2.val
                search.next = l2.next
                break
            if l2 is None:
                search.val = l1.val
                search.next = l1.next
                break
    
            if l1.val < l2.val:
                search.val = l1.val
                l1 = l1.next
            else:
                search.val = l2.val 
                l2 = l2.next
            
            search.next = ListNode()
            search = search.next
            
        if answer.val == -101:
            return None
        return answer