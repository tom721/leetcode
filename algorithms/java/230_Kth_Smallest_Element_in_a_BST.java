/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> sort = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        traverse(root);
        return sort.get(k - 1);
    }

    void traverse(TreeNode node) {
        if (node.left != null) {
            traverse(node.left);
        }
        sort.add(node.val);
        if (node.right != null) {
            traverse(node.right);
        }
    }
}