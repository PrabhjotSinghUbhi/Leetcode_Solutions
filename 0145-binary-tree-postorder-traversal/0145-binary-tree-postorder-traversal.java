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
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        List<Integer> postOrder = new ArrayList<>();

        if (root == null)
            return postOrder;

        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode currentNode = stack1.pop();
            postOrder.add(currentNode.val);

            if (currentNode.left != null)
                stack1.push(currentNode.left);
            if (currentNode.right != null)
                stack1.push(currentNode.right);
        }

        // while(!stack2.isEmpty()) {
        //     postOrder.add(stack2.pop().val);
        // }

        Collections.reverse(postOrder);
        return postOrder;
    }
}