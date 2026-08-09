class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> mp;
        unordered_set<int> mp2;
        for (auto& i : nums1)
            mp.insert(i);

        for (auto& i : nums2)
            mp2.insert(i);

        vector<int> ans;
        for (auto& i : mp2) {
            if (mp.contains(i))
                ans.push_back(i);
        }

        return ans;
    }
};