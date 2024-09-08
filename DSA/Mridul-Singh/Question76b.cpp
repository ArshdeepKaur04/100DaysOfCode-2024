//LEETCODE PROBLEM 124

#include<bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

class Solution {
public:
    int res;

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    int maximum(struct TreeNode* root) {
        if (root == NULL) {
            return 0;
        }
        int left = maximum(root->left);
        int right = maximum(root->right);
        left = max(left, 0);
        right = max(right, 0);
        int currentSum = left + right + root->val;
        res = max(res, currentSum);
        return max(left, right) + root->val;
    }

    int maxPathSum(struct TreeNode* root) {
        res = INT_MIN;
        maximum(root);
        return res;
    }
};