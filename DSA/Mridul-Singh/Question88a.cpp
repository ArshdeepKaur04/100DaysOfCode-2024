//LEETCODE PROBLEM -> 1034 

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    void dfs(vector<vector<int>>& grid, int x, int y, int originalColor, vector<vector<bool>>& visited, vector<pair<int, int>>& borders) {
        int m = grid.size(), n = grid[0].size();
        visited[x][y] = true;
        bool isBorder = false;
        for (auto dir : directions) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != originalColor) {
                isBorder = true;
            } else if (!visited[nx][ny]) {
                dfs(grid, nx, ny, originalColor, visited, borders);
            }
        }
        if (isBorder || x == 0 || x == m - 1 || y == 0 || y == n - 1) {
            borders.push_back({x, y});
        }
    }

    vector<vector<int>> colorBorder(vector<vector<int>>& grid, int row, int col, int color) {
        int m = grid.size(), n = grid[0].size();
        int originalColor = grid[row][col];
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        vector<pair<int, int>> borders;
        dfs(grid, row, col, originalColor, visited, borders);
        for (auto& cell : borders) {
            grid[cell.first][cell.second] = color;
        }
        return grid;
    }
};
