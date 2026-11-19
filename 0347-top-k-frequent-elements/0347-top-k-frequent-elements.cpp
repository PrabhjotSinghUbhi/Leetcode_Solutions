class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        // priority_queue<pair<int, int> , vector<pair<int, int>>, greater<pair<int, int>>> pq;
        priority_queue<pair<int, int>> pq;

        unordered_map<int, int> freq;
        for(int x : nums) freq[x]++;

        for(auto& [key, value] :  freq) {
            pq.push({value, key});
        }

        vector<int> ans;
        for(int i = 0; i < k; i++) {
            int element = pq.top().second;
            pq.pop();
            ans.push_back(element);
        }
        return ans;
    }
};