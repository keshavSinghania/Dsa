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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<Boolean> st2  = new Stack<>();

        if(root == null) return list;
        st1.push(root);
        st2.push(false);

        while(!st1.isEmpty()){
            TreeNode curr = st1.pop();
            boolean visited = st2.pop();

            if(visited){
                list.add(curr.val);
            }else{
                if(curr.right != null){
                    st1.push(curr.right);
                    st2.push(false);
                }
                st1.push(curr);
                st2.push(true);
                if(curr.left != null){
                    st1.push(curr.left);
                    st2.push(false);
                }
            }
        }
        return list;
    }
}