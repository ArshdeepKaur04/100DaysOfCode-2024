//Count Complete Tree Nodes
class Day80_Q2 {

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int nl = countNodes(root.left);
        int nr = countNodes(root.right);

        return 1 + nl + nr;
    }

    public static void main(String[] args) {
        Day80_Q2 solution = new Day80_Q2();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        int result = solution.countNodes(root);
        System.out.println("Number of nodes: " + result);
    }
}
