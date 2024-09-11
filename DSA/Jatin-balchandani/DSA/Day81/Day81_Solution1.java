public class Day81_Solution1 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
        public int countNodes(TreeNode root) {
            int count =0;
            if(root == null) return 0;

            int leftheight =countNodes(root.left);
            int rightheight = countNodes(root.right);

            return 1+ leftheight+rightheight;
        }}
