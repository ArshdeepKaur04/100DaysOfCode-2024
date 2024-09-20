//LEETCODE PROBLEM -> 129

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    void count(TreeNode* root,int* c){
        if(root==nullptr){
            return;
        }
        (*c)++;
        count(root->left,c);
        count(root->right,c);
    }
    int countNodes(TreeNode* root) {
        int c=0;
        count(root, &c);
        return c;
    }
};