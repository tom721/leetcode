/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type Queue struct {
	items []*TreeNode
}

func (q *Queue) Set(value *TreeNode) {
	q.items = append(q.items, value)
}
func (q *Queue) Get() *TreeNode {
	item, items := q.items[0], q.items[1:]
	q.items = items
	return item
}

func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	q := Queue{}
	q.Set(root)
	present := 1
	future := 0
	ans := [][]int{}
	for present != 0 {
		gens := []int{}
		for present != 0 {
			n := q.Get()
			present--
			if n.Left != nil {
				q.Set(n.Left)
				future++
			}
			if n.Right != nil {
				q.Set(n.Right)
				future++
			}
			gens = append(gens, n.Val)
		}
		ans = append(ans, gens)
		present = future
		future = 0
	}
	return ans
}