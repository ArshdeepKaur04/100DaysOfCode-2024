import java.util.*;
public class Day68_Solution1 {
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
        List<Integer> result = new ArrayList<>();
        public List<Integer> postorderTraversal(TreeNode root) {
            postOrder(root);
            return result;
        }

        public void postOrder(TreeNode node){
            if(node == null){
                return;
            }

            postOrder(node.left);

            postOrder(node.right);
            result.add(node.val);
        }

    }

