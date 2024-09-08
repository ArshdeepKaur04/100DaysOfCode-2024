// LEETCODE PROBLEM 99

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    TreeNode* prev = nullptr;
    TreeNode* first = nullptr;
    TreeNode* second = nullptr;
    void inorder(TreeNode* root) {
        if (root == nullptr)
            return;
        inorder(root->left);
        if (prev != nullptr && root->val < prev->val) {
            if (first == nullptr)
                first = prev;
            second = root;
        }
        prev = root;
        inorder(root->right);
    }

    void recoverTree(TreeNode* root) {
        if (root == nullptr)
            return;
        inorder(root);
        int temp = first->val;
        first->val = second->val;
        second->val = temp;
    }
};