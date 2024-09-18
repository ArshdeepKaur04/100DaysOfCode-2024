import java.util.HashMap;
import java.util.Map;

class Day79_Q1 {
    private Map<Integer, Integer> valueIndexMapping = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMapping.put(inorder[i], i);
        }
        return build(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int root, int start, int end) {
        if (start > end)
            return null;
        
        TreeNode rootNode = new TreeNode(postorder[root]);
        int rootIndexInorder = valueIndexMapping.get(postorder[root]);
        rootNode.left = build(inorder, postorder, root - (end - rootIndexInorder + 1), start, rootIndexInorder - 1);
        rootNode.right = build(inorder, postorder, root - 1, rootIndexInorder + 1, end);
        return rootNode;
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
        Day79_Q1 solution = new Day79_Q1();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode result = solution.buildTree(inorder, postorder);
        System.out.println("Root of the tree: " + result.val);
    }
}
