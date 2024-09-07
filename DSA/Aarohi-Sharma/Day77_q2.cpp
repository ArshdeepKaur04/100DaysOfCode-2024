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
    void flatten(TreeNode* root) {
       if(root==NULL)return;
        stack<TreeNode*>st;
        if(root->left!=NULL){
            if(root->right!=NULL){
             st.push(root->right);
            }
           TreeNode* temp=root->left;
           root->left=NULL;
           root->right=temp;
        } 
        flatten(root->right);
        if(root->right!=NULL){
            TreeNode* dummy=root->right;
            while(dummy->right!=NULL){
                dummy=dummy->right;
            }
            while(!st.empty()){
                dummy->right=st.top();
                flatten(st.top());
                st.pop();
            }
        }
    }
};
