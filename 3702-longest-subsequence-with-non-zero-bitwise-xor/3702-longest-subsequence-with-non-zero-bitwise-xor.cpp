class Solution {
public:
    int longestSubsequence(vector<int>& nums) {

        ios::sync_with_stdio(false);
        cin.tie(nullptr);

        int xorr = 0;
        bool isZero = true;
        for (auto& i : nums) {
            xorr ^= i;
            if (i != 0)
                isZero = false;
        }

        if (xorr != 0)
            return nums.size();

        if (!isZero)
            return nums.size() - 1;

        return 0;
    }
};