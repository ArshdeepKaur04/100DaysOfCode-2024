class Solution {
public:
    int count = 0;
    
    int inorderTraversal(TreeNode* root) {
        //base case 
        if (root == NULL) {
            return count;
        }

        inorderTraversal(root -> left);
        count++;
        inorderTraversal(root -> right);

        return count;
    }

    int countNodes(TreeNode* root) {
        int ans = inorderTraversal(root);
        return ans;
    }
};
