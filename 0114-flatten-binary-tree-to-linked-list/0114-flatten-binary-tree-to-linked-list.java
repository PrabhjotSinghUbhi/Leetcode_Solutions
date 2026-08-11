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
    public void flatten(TreeNode root) {

        if (root == null)
            return;

        ArrayList<TreeNode> preOrder = new ArrayList<>();
        helper(root, preOrder);

        root.left = null;
        root.right = null;
        TreeNode tmp = root;
        for (int i = 1; i < preOrder.size(); i++) {
                tmp.right = preOrder.get(i);
                tmp = tmp.right;
            // System.out.print(node.val + " ");
        }
    }

    void helper(TreeNode root, ArrayList<TreeNode> preOrder) {
        if (root == null)
            return;

        preOrder.add(new TreeNode(root.val));
        helper(root.left, preOrder);
        helper(root.right, preOrder);
    }
}