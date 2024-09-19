class Solution {
public:
    // Helper function for DFS traversal
    int dfs(TreeNode* root, int& res) {
        if (!root) return 0;

        // Calculate maximum path sum on the left and right subtrees
        int leftMax = dfs(root->left, res);
        int rightMax = dfs(root->right, res);

        // If the maximum sum is negative, we ignore that branch by considering it as 0
        leftMax = max(leftMax, 0);
        rightMax = max(rightMax, 0);

        // Update the result for the current node by including both left and right paths
        res = max(res, root->val + leftMax + rightMax);

        // Return the maximum path sum from the current node either to the left or right child
        return root->val + max(leftMax, rightMax);
    }

    int maxPathSum(TreeNode* root) {
        int res = root->val;

        // Start the DFS traversal from the root
        dfs(root, res);
        return res;
    }
};
