/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void dfs(TreeNode* root, int isLeft, int len, int& mx){
        if(!root){
            return;
        }
        mx = max(mx, len);
        if(isLeft){    
            dfs(root -> right, 0, len + 1, mx); 
            dfs(root -> left, 1, 1, mx); 
        }
        else{ 
            dfs(root -> left, 1, len + 1, mx); 
            dfs(root -> right, 0, 1, mx); 
        }
    }
    int longestZigZag(TreeNode* root) {
        int mx = 0;
        dfs(root -> left, 1, 1, mx); 
        dfs(root -> right, 0, 1, mx);
        return mx;
    }
};
