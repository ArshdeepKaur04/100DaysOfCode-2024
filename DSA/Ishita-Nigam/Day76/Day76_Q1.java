class Day76_Q1 {
    int res = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = dfs(root.left), right = dfs(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
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
        Day76_Q1 solution = new Day76_Q1();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        
        int result = solution.minCameraCover(root);
        System.out.println("Minimum cameras needed: " + result);
    }
}
