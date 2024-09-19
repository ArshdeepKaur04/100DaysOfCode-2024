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
    void DFS(TreeNode* root,int num,int* sum){
        if(root==NULL)
            return;
        if(root->left || root->right)
            num = num*10 + root->val;
        else{
            *sum += num*10 + root->val;
            return;
        }
        DFS(root->left,num,sum);
        DFS(root->right,num,sum);
    }
    int sumNumbers(TreeNode* root) {
        int sum = 0;
        DFS(root,0,&sum);
        return sum;
    }
};
