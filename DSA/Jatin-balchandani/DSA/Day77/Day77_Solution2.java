public class Day77_Solution2 {
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
    // Algo used: Morris Bhai ka Traversal
    // We are just linking de-linking and linking liks thats it
    // See the dry run its easy peasyyy of striver using the morris bhai ka traversal
//  TC: O N , SC: O 1
        public void flatten(TreeNode root) {
            TreeNode curr= root;

            while(curr!= null){
                if(curr.left!= null){
                    TreeNode prev= curr.left;
                    while(prev.right!= null){
                        prev= prev.right;
                    }
                    prev.right= curr.right;
                    curr.right= curr.left;
                    curr.left= null;
                }
                curr= curr.right;
            }
        }
    }
