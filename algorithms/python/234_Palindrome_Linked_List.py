# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        value = []
        while True:
            value.append(head.val)
            if head.next == None:
                break
            head = head.next
        return value == value[::-1]