class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans = getSubsets(nums);
        return ans;
    }

    vector<vector<int>> getSubsets(vector<int>& nums) {
        vector<vector<int>> outer;
        vector<int> t;
        outer.push_back(t);

        for (auto& num : nums) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                vector<int> inner = outer[i];
                inner.push_back(num);
                outer.push_back(inner);
            }
        }

        return outer;
    }
};