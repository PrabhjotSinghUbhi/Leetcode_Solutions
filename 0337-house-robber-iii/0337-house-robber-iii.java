class Solution {
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> dp = new HashMap<>();
        return solve(root, dp);
    }

    int solve(TreeNode node, HashMap<TreeNode, Integer> dp) {

        if(node == null) {
            return 0;
        }

        if(dp.containsKey(node) == true) {
            return dp.get(node);
        }

        // Take current node
        int take = node.val;

        if(node.left != null) {
            take += solve(node.left.left, dp);
            take += solve(node.left.right, dp);
        }

        if(node.right != null) {
            take += solve(node.right.left, dp);
            take += solve(node.right.right, dp);
        }

        // Skip current node
        int skip = solve(node.left, dp) + solve(node.right, dp);

        int ans = Math.max(skip, take);
        dp.put(node, ans);

        return dp.get(node);
    }
}