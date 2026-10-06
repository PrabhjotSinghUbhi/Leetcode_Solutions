class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        solve("", ans, 0, 0, n);
        return ans;
    }

    void solve(string p, vector<string>& ans, int opened, int closed, int n) {

        //base case.
        if(opened == n && closed == n) {
            ans.push_back(p);
            return;
        }

        //add opening bracket.
        if(opened < n) {
            solve(p + '(' , ans,opened + 1, closed, n);
        }

        //add closed bracket if you have corresponding opening bracket.
        if(closed < n && opened > closed) {
            solve(p + ')', ans, opened, closed + 1, n);
        }

    }
};