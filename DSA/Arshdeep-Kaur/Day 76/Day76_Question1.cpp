class Solution {
public:
    int cam;
    
    int minCameraCover(TreeNode* root) {
         // (0) -> cam + 1, (1, 2) -> cam
        // If the root is not covered, add one camera
        return dfs(root) == 0 ? cam + 1 : cam;
    }

    // 2 -> Has camera
    // 1 -> Covered with camera
    // 0 -> No camera is covering this node
    int dfs(TreeNode* node) {
        if (node == nullptr) {
            return 1;  // Null nodes are covered
        }
        
        int left = dfs(node->left);
        int right = dfs(node->right);
        
        // If either child is not covered, place a camera here
        if (left == 0 || right == 0) {
            cam++;
            return 2;
        }
        // If any child has a camera, this node is covered
        else if (left == 2 || right == 2) {
            return 1;
        }
        // If both children are covered but do not have cameras
        return 0;
    }
};
