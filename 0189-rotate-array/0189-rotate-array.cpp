class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        //three reversal algorithm.
        int r = k % nums.size();

        //reverse the entrie array.
        ranges::reverse(nums);
        ranges::reverse(nums.begin(), nums.begin() + r);
        ranges::reverse(nums.begin() + r, nums.end());
    }
};