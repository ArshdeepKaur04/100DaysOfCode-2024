// Day78_Q1: Delete Node in a Binary Search Tree

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Day78_Q1 {
    public static TreeNode fis(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.right == null && root.left == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode IS = fis(root.right);
            root.val = IS.val;
            root.right = deleteNode(root.right, IS.val);
        }
        return root;
    }

    // Main method for testing
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        Day78_Q1 solution = new Day78_Q1();

        System.out.println("Before Deletion: ");
        // Add a method to print the tree in inorder if needed
        
        root = solution.deleteNode(root, 3);

        System.out.println("After Deletion: ");
        // Add a method to print the tree in inorder if needed
    }
}
