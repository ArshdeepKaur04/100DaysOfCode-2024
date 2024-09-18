//Serialize and Deserialize Binary Tree
import java.util.LinkedList;
import java.util.Queue;

class Day80_Q1 {

    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res = res + "n ";
            } else {
                res = res + node.val + " ";
            }
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        System.out.print(res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] nodeValues = data.split(" ");
        TreeNode node = new TreeNode(Integer.parseInt(nodeValues[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        
        for (int i = 1; i < nodeValues.length; i++) {
            TreeNode parentNode = queue.poll();
            if (!nodeValues[i].equals("n")) {
                parentNode.left = new TreeNode(Integer.parseInt(nodeValues[i]));
                queue.offer(parentNode.left);
            }
            if (!nodeValues[++i].equals("n")) {
                parentNode.right = new TreeNode(Integer.parseInt(nodeValues[i]));
                queue.offer(parentNode.right);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Day80_Q1 codec = new Day80_Q1();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = codec.serialize(root);
        System.out.println("Serialized Tree: " + serialized);

        TreeNode deserializedRoot = codec.deserialize(serialized);
        System.out.println("Tree deserialized successfully.");
    }
}
