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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        print(ans, root);
        return ans;

    }
    //function to print the pre-order
    public void print(List<Integer> ans, TreeNode root){
        //add the root to the ans
        ans.add(root.val);

        //left call
        if(root.left != null){
            print(ans, root.left);
        }

        //right call
        if(root.right != null){
            print(ans, root.right);
        }
    }
}