class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> permutes;
        vector<int> curr;
        helper(curr, nums, permutes);
        return permutes;
    }

    void helper(vector<int> p, vector<int> up, vector<vector<int>>& result) {
        if (up.empty()) {
            result.push_back(p);
            return;
        }

        int num = up[0];
        vector<int> tmp(up.begin() + 1, up.end());

        for (int i = 0; i <= p.size(); i++) {
            vector<int> tp(p.begin(), p.end());
            tp.insert(tp.begin() + i, num);
            helper(tp, tmp, result);
        }
    }
};