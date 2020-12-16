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
    public boolean isValidBST(TreeNode root) {
        return isChildValidBST(root, null, null);
    }

    boolean isChildValidBST(TreeNode root, Integer lowerBound, Integer upperBound) {
        boolean left = true;
        boolean right = true;
        if (root.left != null) {
            if (root.left.val >= root.val || (lowerBound != null && root.left.val <= lowerBound)) {
                left = false;
            } else {
                left = isChildValidBST(root.left, lowerBound, root.val);
            }
        }
        if (root.right != null) {
            if (root.right.val <= root.val || (upperBound != null && root.right.val >= upperBound)) {
                right = false;
            } else {
                right = isChildValidBST(root.right, root.val, upperBound);
            }
        }
        return left && right;
    }
}