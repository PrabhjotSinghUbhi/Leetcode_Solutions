class Solution {
public:
    string longestPalindrome(string s) {
        string s1 = s;
        reverse(s.begin(), s.end());
        string s2 = s;

        int n = s.length();

        vector<vector<int>> dp(n + 1, vector<int>(n + 1, 0));
        int maxx = 0;
        int endIndex = -1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                // matches.
                if (s1[i - 1] == s2[j - 1]) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    int cl = dp[i][j];
                    int oSIndex = i - cl;
                    int rSIndex = n - j;

                    if(oSIndex == rSIndex) {
                        if(dp[i][j] > maxx) {
                            maxx = dp[i][j];
                            endIndex = i;
                        }
                    }

                }

            }
        }

        if(endIndex == -1) return "";//not any common found
        
        return s1.substr(endIndex - maxx, maxx);
    }
};