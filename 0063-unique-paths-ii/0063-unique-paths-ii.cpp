class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        vector<vector<int>> dp(obstacleGrid.size(),
                               vector<int>(obstacleGrid[0].size(), -1));
        return solve(obstacleGrid, 0, 0, dp);
    }

    int solve(vector<vector<int>>& grid, int i, int j, vector<vector<int>>& dp) {

        if (i == grid.size() || j == grid[0].size() || grid[i][j] == 1)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (i == grid.size() - 1 && j == grid[0].size() - 1) {
            return 1;
        }

        // move right + move down
        return dp[i][j] = solve(grid, i + 1, j, dp) + solve(grid, i, j + 1, dp);
    }
};