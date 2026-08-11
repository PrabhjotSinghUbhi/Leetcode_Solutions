class Solution {
public:
    int missingInteger(vector<int>& nums) {
        int n = nums.size();

        int sqSum = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sqSum += nums[i];
            } else {
                break;
            }
        }

        int mp[51] = {false};
        for (auto i : nums) mp[i] = true;

        while (sqSum <= 50 && mp[sqSum]) {
            sqSum++;
        }

        return sqSum;
    }
};