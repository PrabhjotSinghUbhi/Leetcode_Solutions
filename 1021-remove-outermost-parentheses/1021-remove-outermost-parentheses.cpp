class Solution {
public:
    string removeOuterParentheses(string s) {
        int balance = 0;
        string ans = "";

        for (auto& ch : s) {
            if (ch == '(') {
                balance++;
                if (balance >= 2)
                    ans += ch;
            } else {
                balance--;
                if (balance >= 1)
                    ans += ch;
            }
        }

        return ans;
    }
};