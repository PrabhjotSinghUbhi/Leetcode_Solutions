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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        helper(root,ls);
        return ls;
    }

    void helper(TreeNode root ,ArrayList<Integer> ls) {
        if(root == null) {
            return;
        }

        helper(root.left,ls);
        ls.add(root.val);
        helper(root.right,ls);
    }
}