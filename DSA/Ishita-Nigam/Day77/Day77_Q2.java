// Flatten Binary Tree to Linked List

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Day77_Q2 {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        TreeNode current = root;
        while (current != null) {

            if (current.left != null) {
                TreeNode last = current.left;
                while (last.right != null) {
                    last = last.right;
                }

                last.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    // Helper method to print the flattened tree
    public void printFlattened(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        Day77_Q2 solution = new Day77_Q2();

        System.out.println("Before Flattening: ");
        solution.printFlattened(root);
        System.out.println();

        solution.flatten(root);

        System.out.println("After Flattening: ");
        solution.printFlattened(root);
    }
}
