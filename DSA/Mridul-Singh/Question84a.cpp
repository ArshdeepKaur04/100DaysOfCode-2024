//GFG PROBLEM -> DFS of Graph

#include<bits/stdc++.h>
using namespace std;

class Solution {
  public:
    void dfs(int node, vector<int>& visited, vector<int> adj[], vector<int>& result) {
        visited[node] = 1;
        result.push_back(node);
        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj, result);
            }
        }
    }
    vector<int> dfsOfGraph(int V, vector<int> adj[]) {
        vector<int> result;
        vector<int> visited(V, 0);
        dfs(0, visited, adj, result);
        return result;
    }
};