# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        first = 0
        second = 0
        
        exp = 1
        while l1:
            first += l1.val * exp
            exp *= 10
            l1 = l1.next
        
        exp = 1
        while l2:
            second += l2.val * exp
            exp *= 10
            l2 = l2.next
        
        answer = ListNode()
        p = answer
        add = first + second
        
        while True:
            p.next = ListNode(add%10)
            p = p.next
            add //= 10
            if add is 0:
                break
        
        return answer.next