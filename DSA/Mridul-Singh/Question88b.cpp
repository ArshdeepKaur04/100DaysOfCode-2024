//LEETCODE PROBLEM -> 773

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int slidingPuzzle(vector<vector<int>>& board) {
        vector<vector<int>> moves = {
            {1, 3}, {0, 2, 4}, {1, 5},
            {0, 4}, {1, 3, 5}, {2, 4}
        };
        string start = "";
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                start += to_string(board[i][j]);
            }
        }
        string goal = "123450";
        queue<pair<string, int>> q;
        unordered_set<string> visited;
        q.push({start, 0});
        visited.insert(start);
        while (!q.empty()) {
            auto current = q.front();
            q.pop();
            if (current.first == goal) {
                return current.second;
            }
            int zeroIndex = current.first.find('0');
            for (int move : moves[zeroIndex]) {
                string nextState = current.first;
                swap(nextState[zeroIndex], nextState[move]);
                if (visited.find(nextState) == visited.end()) {
                    q.push({nextState, current.second + 1});
                    visited.insert(nextState);
                }
            }
        }
        return -1;
    }
};
