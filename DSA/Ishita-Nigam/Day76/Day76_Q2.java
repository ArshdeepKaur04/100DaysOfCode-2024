class Day76_Q2 {
    // Initialise a class-level max variable
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) 
            return 0;

        sum(root);
        return max;
    }

    public int sum(TreeNode root) {
        // For leaf node, sum contribution is 0
        if (root == null)
            return 0;

        // If negative, will never contribute to max sum, so ignore
        int lsum = Math.max(sum(root.left), 0);
        int rsum = Math.max(sum(root.right), 0);

        // Sum at self node will be sum of all
        int self = root.val + rsum + lsum; 
        max = Math.max(max, self);

        // Contribution to the parent node comes from either left or right
        return Math.max(lsum, rsum) + root.val;
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
        Day76_Q2 solution = new Day76_Q2();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int result = solution.maxPathSum(root);
        System.out.println("Maximum path sum: " + result);
    }
}
