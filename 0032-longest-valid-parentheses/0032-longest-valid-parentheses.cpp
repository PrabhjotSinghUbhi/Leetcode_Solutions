class Solution {
public:
    int longestValidParentheses(string s) {
        int l = 0, r = 0, mx = 0;

        for (auto& ch : s) {

            if (ch == '(')
                l++;
            else
                r++;

            if (l == r)
                mx = max(mx, l * 2);

            if (r > l) {
                r = 0;
                l = 0;
            }
        }

        r = 0;
        l = 0;

        for (auto& ch : s | views::reverse) {

            if (ch == '(')
                l++;
            else
                r++;

            if (l == r)
                mx = max(mx, l * 2);

            if (r < l) {
                r = 0;
                l = 0;
            }
        }

        return mx;
    }
};