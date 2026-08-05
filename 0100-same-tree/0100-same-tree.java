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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        preOrder(p, a);
        preOrder(q, b);
        
        return a.equals(b);
    }

    void preOrder(TreeNode root, List<String> ls) {
        if (root == null) {
            ls.add("null");
            return;
        }

        ls.add(String.valueOf(root.val));
        preOrder(root.left, ls);
        preOrder(root.right, ls);
    }
}