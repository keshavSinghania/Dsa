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
class Solution {
    int ans = 0;
    public int maxDepth(TreeNode root) {
        int tempDepth  = 0;
        findDepth(tempDepth, root);

        return ans;
    }

    public void findDepth(int tempDepth, TreeNode root){
        if(root == null){
            ans = Math.max(ans, tempDepth);
            tempDepth = 0;
            return;
        }
        //first go left
        findDepth(tempDepth + 1, root.left);
        findDepth(tempDepth + 1, root.right);
    
    }
}