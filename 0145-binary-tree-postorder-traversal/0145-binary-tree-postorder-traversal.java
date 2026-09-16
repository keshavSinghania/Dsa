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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        postOrder(ans, root);
        return ans;
    }
    public void postOrder(ArrayList<Integer> ans, TreeNode root){
        if(root == null){
            return;
        }
        postOrder(ans, root.left);
        postOrder(ans, root.right);

        ans.add(root.val);
    }
}