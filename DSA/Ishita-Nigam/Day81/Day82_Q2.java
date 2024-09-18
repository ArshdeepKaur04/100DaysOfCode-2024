public class Day82_Q2 {

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] sum = {0};
        helper(root, 0, sum);
        return sum[0];
    }

    private static void helper(TreeNode root, int currentSum, int[] sum) {
        if (root == null) {
            return;
        }

        currentSum = currentSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            sum[0] += currentSum;
            return;
        }

        helper(root.left, currentSum, sum);
        helper(root.right, currentSum, sum);
    }

    public static void main(String[] args) {
        Day82_Q2 solution = new Day82_Q2();

        // Constructing the tree:
        //         4
        //        / \
        //       9   0
        //      / \
        //     5   1
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        int result = solution.sumNumbers(root);
        System.out.println("Sum of all root-to-leaf numbers: " + result);
    }
}
