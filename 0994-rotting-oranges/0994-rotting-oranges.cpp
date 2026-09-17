class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        queue<vector<int>> q;
        int cnt = 0;
        int ans = 0;

        vector<int> dr = {-1, 0, 0, 1};
        vector<int> dc = {0, 1, -1, 0};

        // Multi-source BFS initialization
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.push({i, j, 0});
                } else if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }

        if (cnt == 0) return 0;

        while (!q.empty()) {
            auto curr = q.front();
            q.pop();

            int row = curr[0];
            int col = curr[1];
            int time = curr[2];

            ans = max(ans, time);

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 1) {

                    grid[nr][nc] = 2;
                    cnt--;

                    q.push({nr, nc, time + 1});
                }
            }
        }

        return cnt == 0 ? ans : -1;
    }
};