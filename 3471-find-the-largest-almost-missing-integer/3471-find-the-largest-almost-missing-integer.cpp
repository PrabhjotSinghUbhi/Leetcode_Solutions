class Solution {
public:
    int largestInteger(vector<int>& nums, int k) {

        int n = nums.size();
        if(n == k) {
            int maxE = *max_element(nums.begin(), nums.end());
            return maxE;
        }

        vector<int> f(51,0);
        for(int i = 0; i <= n - k; ++i) {
            for(int j = i; j < i + k; ++j) {
                f[nums[j]]++;
            }
        }

        int maxAns = -1;
        for(int i = 0; i <= 50; i++) {
            if(f[i] == 1) {
                maxAns = max(maxAns, i);
            }
        }

        return maxAns;
    }
};