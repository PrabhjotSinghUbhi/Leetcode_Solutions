class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> ans = getSubsets(nums);
        return ans;
    }

    vector<vector<int>> getSubsets(vector<int> nums) {
        sort(nums.begin(),nums.end());
        vector<vector<int>> outer;
        int start = 0, end = 0;

        vector<int> t;
        outer.push_back(t);

        for (int i = 0; i < nums.size(); i++) {
            int n = outer.size();
            start = 0;
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            for (int j = start; j < n; j++) {
                vector<int> inner = outer[j];
                inner.push_back(nums[i]);
                outer.push_back(inner);
            }
        }

        return outer;
    }
};