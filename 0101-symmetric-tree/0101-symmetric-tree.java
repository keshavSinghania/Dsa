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
    boolean ans = true;
    public boolean isSymmetric(TreeNode root) {
        check(root.left, root.right);
        return ans;
    }
    //fucntion to check wheather given tree is symmetric or not
    public void check(TreeNode leftSide , TreeNode rightSide){
        if(leftSide == null && rightSide == null){
            return;
        }
        if(leftSide == null){
            ans = false;
            return;
        }
        if(rightSide == null){
            ans = false;
            return;
        }

        if(rightSide.val != leftSide.val){
            ans = false;
            return;
        }
        check(leftSide.left, rightSide.right);
        check(leftSide.right,rightSide.left);
        return;
    }
}