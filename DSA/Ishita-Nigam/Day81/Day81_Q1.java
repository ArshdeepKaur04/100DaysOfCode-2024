//Longest ZigZag Path in a Binary Tree
class Day81_Q1 {

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int maxZigZag = 0;

    private void dfs(TreeNode node, char last, int length) {
        if (node == null) return;

        maxZigZag = Math.max(maxZigZag, length);

        dfs(node.left, 'l', last != 'l' ? length + 1 : 1);
        dfs(node.right, 'r', last != 'r' ? length + 1 : 1);
    }

    public int longestZigZag(TreeNode root) {
        dfs(root, 'l', 0);
        return maxZigZag;
    }

    public static void main(String[] args) {
        Day81_Q1 solution = new Day81_Q1();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        int result = solution.longestZigZag(root);
        System.out.println("Longest ZigZag Path: " + result);
    }
}
