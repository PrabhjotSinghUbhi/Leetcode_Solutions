class Solution {
public:
    bool isSubsequence(string s, string t) {
        // string p = "";
        // return solve(p, t, s, 0);
        int p1 = 0;
        for (int i = 0; i < t.length(); i++) {
            if (p1 < s.length() && s[p1] == t[i])
                p1++;
        }

        if (p1 == s.length())
            return true;
        return false;
    }

    bool solve(string p, string& s, string& target, int index) {

        if (index == s.size()) {
            if (p == target)
                return true;
            return false;
        }

        // take the char OR don't take it.
        return solve(p + s[index], s, target, index + 1) ||
               solve(p, s, target, index + 1);
    }
};