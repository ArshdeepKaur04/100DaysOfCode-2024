//LEETCODE PROBLEM 968

#include <iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    int cameras = 0;
    int dfs(TreeNode* node) {
        if (!node) return 2;
        int leftState = dfs(node->left);
        int rightState = dfs(node->right);
        if (leftState == 0 || rightState == 0) {
            cameras++;
            return 1;
        }
        if (leftState == 1 || rightState == 1) {
            return 2;
        }
        return 0;
    }
    
    int minCameraCover(TreeNode* root) {
        if (dfs(root) == 0) {
            cameras++;
        }
        return cameras;
    }
};

int main() {
    TreeNode* root = new TreeNode(0);
    root->left = new TreeNode(0);
    root->left->left = new TreeNode(0);
    root->left->right = new TreeNode(0);
    Solution solution;
    cout << "Minimum number of cameras needed: " << solution.minCameraCover(root) << endl;  // Output: 1
    return 0;
}
