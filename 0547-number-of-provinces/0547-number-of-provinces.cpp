class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        vector<vector<int>> adj(n + 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    adj[i + 1].push_back(j + 1);
                }
            }
        }

        vector<bool> vis(n + 1, false);
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(!vis[i]) {
                cnt++;
                dfs(i, vis, adj);
            }
        }

        return cnt;
    }

    void dfs(int start, vector<bool>& vis, vector<vector<int>>& adj) {
        vis[start] = true;

        for (int neighbour: adj[start]) {
            if(!vis[neighbour]) {
                dfs(neighbour, vis, adj);
            }
        }
    }
};