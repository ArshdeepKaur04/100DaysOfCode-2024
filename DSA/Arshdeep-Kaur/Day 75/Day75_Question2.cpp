class Solution {
public:
    int steps = 0;

    int findSteps(TreeNode* root) {
        if (root == NULL) {
            return NULL;
        }

        int l = findSteps(root->left);
        int r = findSteps(root->right);
        steps += abs(l) + abs(r);
        
        return (l + r + root->val-1);
    }

    int distributeCoins(TreeNode* root) {
        findSteps(root);
        return steps;   
    }
};
