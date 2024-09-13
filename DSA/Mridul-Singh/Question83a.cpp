//LEETCODE PROBLEM -> 785

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isBipartite(std::vector<std::vector<int>>& graph) {
        int n = graph.size();
        std::vector<int> color(n, -1);
        for (int start = 0; start < n; ++start) {
            if (color[start] == -1) {
                std::queue<int> q;
                q.push(start);
                color[start] = 0;
                while (!q.empty()) {
                    int node = q.front();
                    q.pop();
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[node];
                            q.push(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
};
