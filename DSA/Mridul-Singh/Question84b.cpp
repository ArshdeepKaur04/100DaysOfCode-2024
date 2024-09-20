//LEETCODE PROBLEM -> 399

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool dfs(const string& start, const string& end, unordered_map<string, vector<pair<string, double>>>& graph, unordered_set<string>& visited, double& result) {
        if (start == end) {
            return true;
        }
        visited.insert(start);
        for (const auto& neighbor : graph[start]) {
            const string& next_node = neighbor.first;
            double weight = neighbor.second;
            if (!visited.count(next_node)) {
                double temp_result = result * weight;
                if (dfs(next_node, end, graph, visited, temp_result)) {
                    result = temp_result;
                    return true;
                }
            }
        }
        return false;
    }
    
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        unordered_map<string, vector<pair<string, double>>> graph;
        for (int i = 0; i < equations.size(); ++i) {
            const string& a = equations[i][0];
            const string& b = equations[i][1];
            double value = values[i];
            graph[a].push_back({b, value});
            graph[b].push_back({a, 1.0 / value});
        }
        vector<double> results;
        for (const auto& query : queries) {
            const string& start = query[0];
            const string& end = query[1];
            if (!graph.count(start) || !graph.count(end)) {
                results.push_back(-1.0);
                continue;
            }
            if (start == end) {
                results.push_back(1.0);
                continue;
            }
            unordered_set<string> visited;
            double result = 1.0;
            if (dfs(start, end, graph, visited, result)) {
                results.push_back(result);
            } else {
                results.push_back(-1.0);
            }
        }
        return results;
    }
};
