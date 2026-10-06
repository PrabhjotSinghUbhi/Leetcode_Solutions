class Solution {
public:
    bool isValid(string s) {
        unordered_map<char, char> mp = {
            {')', '('}, {'}', '{'}, {']', '['}
        };
        stack<char> st;

        for (auto& ch : s) {
            if (mp.contains(ch)) {
                if(st.empty() || st.top() != mp[ch]) return false;
                st.pop();
            } else {
                st.push(ch);
            }
        }

        return st.empty();
    }
};