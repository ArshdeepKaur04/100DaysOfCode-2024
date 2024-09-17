class Solution {
public:
    int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {
        int n = routes.size(), maxi = 0;
        if(source == target) return 0;
        unordered_map<int, vector<int>> mp;
        for(int i = 0; i < n; i++) for(auto it: routes[i]) mp[it].push_back(i), maxi = max(maxi, it);
        vector<int> visit(maxi + 1, 1);
        vector<int> visitbus(n, 1);
        queue<pair<int, int>> q;
        for(auto it : mp[source]) q.push({source, it}), visit[source] = 0;
        int count = 1;
        while(!q.empty()){
            int l = q.size();
            while(l){
                int curstop = q.front().first;
                int curbus = q.front().second;
                q.pop();
                if(visitbus[curbus]){
                    for(auto nxtstop : routes[curbus]){
                        if(nxtstop == curstop) continue;
                        if(nxtstop == target) return count;

                        if(visit[nxtstop]){
                            for(auto it : mp[nxtstop]) q.push({nxtstop, it});
                            visit[nxtstop] = 0;
                        }
                    }
                    visitbus[curbus] = 0;
                }
                l--;
            }
            count++;
        }
        return -1;
    }
};
