/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	p := make([]*ListNode, 0, 5)
	h := head

	sz := 0
	for {
		p = append(p, h)
		sz++

		if h.Next == nil {
			break
		}

		h = h.Next
	}

	if sz == n {
		head = head.Next
		return head
	}

	p[sz-n-1].Next = p[sz-n].Next

	return head
}