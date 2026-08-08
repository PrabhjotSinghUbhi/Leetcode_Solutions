class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<int,int> mp;
        for(char ch : s) mp[ch]++;

        for(int i = 0; i < s.size(); i++) {
            if(mp[s[i]] < 2) {
                return i;
            }
        }
        
        return - 1;
    }
};