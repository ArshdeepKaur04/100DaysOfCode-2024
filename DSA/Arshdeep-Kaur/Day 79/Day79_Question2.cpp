class Solution {
public:
    bool isValidBST(TreeNode* root) {
        return validBST(root, LONG_MIN, LONG_MAX);
    }

    bool validBST(TreeNode* root, long minVal, long maxVal) {
        if (root == NULL) {
            return true;
        }

        if (root->val >= maxVal || root->val <= minVal) {
            return false;
        }

        return validBST(root->left, minVal, root->val) && validBST(root->right, root->val, maxVal);
    }
};
