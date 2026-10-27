class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        //make the directed graph.
        vector<vector<int>> adj(numCourses);
        vector<int> id(numCourses);
        for(int i = 0; i < prerequisites.size(); i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            adj[b].push_back(a);
            id[a]++;
        }

        queue<int> q;

        for(int i = 0; i < numCourses; i++) {
            if(id[i] == 0) q.push(i);
        }

        int cnt = 0;
        while(!q.empty()) {
            int u = q.front();
            q.pop();

            cnt++;

            for(int v : adj[u]) {
                id[v]--;

                if(id[v] == 0) q.push(v);
            }
        }

        return cnt == numCourses;
    }
};