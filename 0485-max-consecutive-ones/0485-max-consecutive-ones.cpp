class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int maxCount = 0;
        int count = 0;
        for (const auto& i : nums) {
            if (i == 1) {
                count++;
                maxCount = max(count, maxCount);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
};