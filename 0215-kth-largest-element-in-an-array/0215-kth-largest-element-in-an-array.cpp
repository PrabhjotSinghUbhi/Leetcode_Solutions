class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        multiset<int> mt;
        for (auto num : nums)
            mt.insert(num);
        auto it = mt.rbegin();
        advance(it, k - 1);
        return *it;
    }
};