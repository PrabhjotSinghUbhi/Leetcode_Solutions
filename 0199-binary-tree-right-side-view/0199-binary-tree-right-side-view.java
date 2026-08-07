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

    List<List<Integer>> bfs = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        bfsF(root);

        List<Integer> ans = new ArrayList<>();
        for(List<Integer> level : bfs) {
            ans.add(level.get(
                level.size() - 1
            ));
        }

        return ans;
    }

    void bfsF(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return;

        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> ls = new ArrayList<>();
            int level = q.size();
            for(int i = 0; i < level; i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);

                ls.add(q.poll().val);
            }
            bfs.add(ls);
        }
    }
}