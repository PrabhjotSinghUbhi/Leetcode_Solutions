class Solution {
public:
    bool canJump(vector<int>& nums) {
        vector<int> dp(nums.size() + 1, -1);
        return solve(nums, 0, dp);
    }

    bool solve(vector<int>& nums, int index, vector<int>& dp) {

        // invalid -> if index >== nums.size();
        if (index >= nums.size())
            return false;

        if (dp[index] != -1)
            return dp[index];

        // successfull state -> reached the last index..
        if (index + 1 == nums.size())
            return true;

        bool ans = false;

        for (int i = 1; i <= nums[index]; i++) {
            ans = ans || solve(nums, index + i, dp);
            if (ans) {
                return dp[index] = true;
            }
        }

        return dp[index] = false;
    }
};