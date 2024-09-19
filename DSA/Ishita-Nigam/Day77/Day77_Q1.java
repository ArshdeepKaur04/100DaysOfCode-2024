// Recover Binary Search Tree
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Day77_Q1 {
    private TreeNode first;
    private TreeNode last;
    private TreeNode prev;
    private TreeNode middle;

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }

        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        if (first != null && last != null) {
            int t = first.val;
            first.val = last.val;
            last.val = t;
        } else if (first != null && middle != null) {
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }

    // Helper method to print the tree in inorder traversal
    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Main method for testing
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        Day77_Q1 solution = new Day77_Q1();

        System.out.println("Before Recovery (Inorder): ");
        solution.printInorder(root);
        System.out.println();

        solution.recoverTree(root);

        System.out.println("After Recovery (Inorder): ");
        solution.printInorder(root);
    }
}
