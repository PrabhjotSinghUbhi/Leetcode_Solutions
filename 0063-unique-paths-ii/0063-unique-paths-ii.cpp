class Solution {
public:
    // int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
    //     vector<vector<int>> dp(obstacleGrid.size(),
    //                            vector<int>(obstacleGrid[0].size(), -1));

    //     // return dp[obstacleGrid.size() - 1][obstacleGrid[0].size() - 1];
    //     return dp[0][0] = solve(obstacleGrid, 0,0, dp);
    // }
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        vector<vector<long long>> dp(obstacleGrid.size(),
                               vector<long long>(obstacleGrid[0].size(), 0));
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();

         if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        dp[m - 1][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (obstacleGrid[i][j] == 1)
                    continue;

                if (i == m - 1 && j == n - 1)
                    continue;

                if(i + 1 < m) 
                    dp[i][j] += dp[i + 1][j];

                if(j + 1 < n)
                    dp[i][j] += dp[i][j + 1];
            }
        }

        return (int) dp[0][0];
    }

    // int solve(vector<vector<int>>& grid, int i, int j,
    //           vector<vector<int>>& dp) {

    //     if (i == grid.size() || j == grid[0].size() || grid[i][j] == 1)
    //         return 0;

    //     if (dp[i][j] != -1)
    //         return dp[i][j];

    //     if (i == grid.size() - 1 && j == grid[0].size() - 1) {
    //         return dp[i][j] = 1;
    //     }

    //     // move right + move down
    //     return dp[i][j] = solve(grid, i + 1, j, dp) + solve(grid, i, j + 1, dp);
    // }
};