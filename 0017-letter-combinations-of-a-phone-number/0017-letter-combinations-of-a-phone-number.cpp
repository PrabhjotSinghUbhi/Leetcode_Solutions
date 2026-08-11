class Solution {
public:
    const vector<vector<string>> keys = {{},
                                       {},
                                       {"a", "b", "c"},
                                       {"d", "e", "f"},
                                       {"g", "h", "i"},
                                       {"j", "k", "l"},
                                       {"m", "n", "o"},
                                       {"p", "q", "r", "s"},
                                       {"t", "u", "v"},
                                       {"w", "x", "y", "z"}};

    vector<string> letterCombinations(string digits) {

        vector<string> ans;
        getAns("", digits, ans);
        return ans;
    }

    void getAns(string p, string up, vector<string>& ans) {
        if (up.empty()) {
            ans.push_back(p);
            return;
        }

        int digit = up[0] - '0';
        for (int i = 0; i < keys[digit].size(); i++) {
            string a = keys[digit][i];
            string tmp = p + a;
            getAns(tmp, up.substr(1), ans);
        }
    }
};