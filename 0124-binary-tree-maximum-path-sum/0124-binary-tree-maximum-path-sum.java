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
        traverseTree(root);
        return ans;
    }
    //function to traverse the tree
    public void traverseTree(TreeNode root){
        if(root == null){
            return;
        }
        int l = findMax(root.left);
        int r = findMax(root.right);
        ans = Math.max(ans, l + r + root.val);

        traverseTree(root.left);
        traverseTree(root.right);
    }
    //function to find max path
    public int findMax(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = findMax(root.left);
        int right = findMax(root.right);

        return Math.max(0, Math.max(left, right) + root.val);
    }
}