class Solution {
public:
    int longestPalindromeSubseq(string s) {
        string s1 = s;
        reverse(s.begin(), s.end());
        string s2 = s;

        int n = s.length();

        vector<vector<int>> dp(n + 1, vector<int>(n + 1, 0));
        int maxx = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                // matches.
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxx = max(maxx, dp[i][j]);
                } else {
                    dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);
                }

            }
        }

        return maxx;
    }
};