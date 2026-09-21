class Solution {
public:
    bool canPartition(vector<int>& nums) {
        // now let's move the the memoization solution.
        // states changing are -> index and s1, and s2 -> 3 variables.
        // we can change it to 2 variables using a total sum of the array, -> if
        // at any index the sum of the subset array is equal to half sum return

        int t_sum = accumulate(nums.begin(), nums.end(), 0);

        // true. also if the sum is odd the the array can't be partitioned.
        if (t_sum % 2 != 0)
            return false;

        int half_sum = t_sum / 2;

        vector<vector<int>> dp(half_sum + 1, vector<int>(nums.size() + 1, -1));

        return solve(nums, 0, half_sum , 0, dp);
    }

    bool solve(vector<int>& nums, int sum, int& half_sum, int index,
               vector<vector<int>>& dp) {

        if (sum > half_sum)
            return false;

        if (dp[sum][index] != -1)
            return dp[sum][index];

        if (sum == half_sum)
            return dp[sum][index] = true;

        if (index >= nums.size())
            return dp[sum][index] = false;

        // base case 1 -> if the sum > half sum.

        // take the element/ don't take that element.
        return dp[sum][index] =
                   solve(nums, sum + nums[index], half_sum, index + 1, dp) ||
                   solve(nums, sum, half_sum, index + 1, dp);
    }

    /**
        bool solve(vector<int>& nums, int s1, int s2, int index) {

            // base case 1 -> when index is out of bounds.
            if (index == nums.size()) {
                // base case 2 -> when subset sum 1 is equal to subset sum 2 and
                // index will be at the last index.
                if (s1 == s2)
                    return true;
                return false;
            };

            // for each index you have 2 choices add it to the first subset 1 or
       to
            // the second subset.

            return solve(nums, s1 + nums[index], s2, index + 1) ||
                   solve(nums, s1, s2 + nums[index], index + 1);
        }
    */
};