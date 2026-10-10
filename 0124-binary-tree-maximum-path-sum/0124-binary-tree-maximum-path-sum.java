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
    public int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        ans = root.val;
        findMax(root);
        return ans;
    }
    //function to traverse the tree
    public int findMax(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = Math.max(0,findMax(root.left));
        int r = Math.max(0,findMax(root.right));
        ans = Math.max(ans, l + r + root.val);

        return root.val + Math.max(l, r);
    }
}