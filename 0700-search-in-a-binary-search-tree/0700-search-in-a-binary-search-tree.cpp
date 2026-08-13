/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* searchBST(TreeNode* root, int val) {

        if (root->left == nullptr && root->right == nullptr) {
            return root;
        }

        TreeNode* ans = solve(root, val);
        return ans;
    }

    TreeNode* solve(TreeNode* root, int target) {
        if (!root)
            return nullptr;

        if (root->val == target) {
            return root;
        } else if (root->val > target) {
            return solve(root->left, target);
        } else {
            return solve(root->right, target);
        }
    }
};