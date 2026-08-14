class Solution {
public:
    int maximumLengthSubstring(string s) {
        // unordered_set<int, int> mp;
        vector<int> mp(256, 0);
        int maxLength = 0;
        int j = 0;
        for (int i = 0; i < s.size(); ++i) {
            mp[s[i] - 'a']++;
            if (mp[s[i] - 'a'] <= 2)
                maxLength = max(maxLength, i - j + 1);
            else
                while (mp[s[i] - 'a'] > 2) {
                    mp[s[j] - 'a']--;
                    j++;
                }
        }

        return maxLength;
    }
};