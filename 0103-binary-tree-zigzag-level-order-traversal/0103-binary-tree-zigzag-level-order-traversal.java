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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        boolean z = true;

        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> ls = new ArrayList<>();
            int level = q.size();

            for (int i = 0; i < level; i++) {
                if (q.peek().left != null)
                    q.offer(q.peek().left);
                if (q.peek().right != null)
                    q.offer(q.peek().right);

                ls.add(q.poll().val);
            }

            // z = !z;
            ans.add(ls);
        }

        for(int i = 0; i < ans.size(); i++) {
            if(i % 2 != 0) {
                Collections.reverse(ans.get(i));
            }
        }

        return ans;
    }
}