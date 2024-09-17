public class Day79_Q2 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) 
            return true;
        if (root.val >= maxVal || root.val <= minVal) 
            return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    // TreeNode class for reference
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // Test method
    public static void main(String[] args) {
        Day79_Q2 solution = new Day79_Q2();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        boolean result = solution.isValidBST(root);
        System.out.println("Is the tree a valid BST? " + result);
    }
}
