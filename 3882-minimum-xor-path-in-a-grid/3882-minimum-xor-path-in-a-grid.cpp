class Solution {
public:
    int minCost(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        vector<vector<unordered_set<int>>> dp(
            m, vector<unordered_set<int>>(n)
        );

        dp[0][0].insert(grid[0][0]);

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (row + 1 < m) {
                    for (int x : dp[row][col]) {
                        dp[row + 1][col].insert(x ^ grid[row + 1][col]);
                    }
                }

                if (col + 1 < n) {
                    for (int x : dp[row][col]) {
                        dp[row][col + 1].insert(x ^ grid[row][col + 1]);
                    }
                }
            }
        }

        return *min_element(
            dp[m - 1][n - 1].begin(),
            dp[m - 1][n - 1].end()
        );
    }
};