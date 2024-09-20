//LEETCODE PROBLEM -> 815

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numBusesToDestination(std::vector<std::vector<int>>& routes, int source, int target) {
        if (source == target) return 0;
        std::unordered_map<int, std::vector<int>> stop_to_buses;
        for (int i = 0; i < routes.size(); ++i) {
            for (int stop : routes[i]) {
                stop_to_buses[stop].push_back(i);
            }
        }
        std::queue<std::pair<int, int>> q;
        std::unordered_set<int> visited_stops;
        std::unordered_set<int> visited_buses;
        q.push({source, 0});
        visited_stops.insert(source);
        while (!q.empty()) {
            int stop = q.front().first;
            int buses_taken = q.front().second;
            q.pop();
            for (int bus : stop_to_buses[stop]) {
                if (visited_buses.count(bus)) continue;
                visited_buses.insert(bus);
                for (int next_stop : routes[bus]) {
                    if (next_stop == target) {
                        return buses_taken + 1;
                    }
                    if (!visited_stops.count(next_stop)) {
                        visited_stops.insert(next_stop);
                        q.push({next_stop, buses_taken + 1});
                    }
                }
            }
        }
        return -1;
    }
};
