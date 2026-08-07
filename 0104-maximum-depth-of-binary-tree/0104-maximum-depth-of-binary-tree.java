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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int maxLevel = 0;

        if (root == null)
            return 0;

        q.offer(root);
        while (!q.isEmpty()) {

            int level = q.size();
            List<Integer> ls = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                if (q.peek().left != null)
                    q.offer(q.peek().left);
                if (q.peek().right != null)
                    q.offer(q.peek().right);

                q.poll();
            }
            
            maxLevel++;
        }

        return maxLevel;
    }
}