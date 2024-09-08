//LEETCODE PROBLEM 114

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void flatten(TreeNode* root) {
        if (root == nullptr) return;
        flatten(root->left);
        flatten(root->right);
        TreeNode* tempRight = root->right;
        root->right = root->left;
        root->left = nullptr;
        TreeNode* temp = root;
        while (temp->right != nullptr) {
            temp = temp->right;
        }
        temp->right = tempRight;
    }
};