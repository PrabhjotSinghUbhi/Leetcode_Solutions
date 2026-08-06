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
    public List<Integer> preorderTraversal(TreeNode root) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> preOrder = new ArrayList<>();

        if (root == null)
            return preOrder;
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode currNode = stack.pop();
            preOrder.add(currNode.val);

            if(currNode.right != null)
                stack.push(currNode.right);

            if(currNode.left != null)
                stack.push(currNode.left);
        }

        return preOrder;
    }
}