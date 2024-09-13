#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int dfs(TreeNode* root, int currentSum) {
        if (root == nullptr) {
            return 0;
        }
        currentSum = currentSum * 10 + root->val;
        if (root->left == nullptr && root->right == nullptr) {
            return currentSum;
        }
        int leftSum = dfs(root->left, currentSum);
        int rightSum = dfs(root->right, currentSum);
        return leftSum + rightSum;
    }
    int sumNumbers(TreeNode* root) {
        return dfs(root, 0);
    }
};
