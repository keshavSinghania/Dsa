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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> qu = new LinkedList<>();
        if(p == null && q == null) return true;

        qu.add(p);
        qu.add(q);

        while(!qu.isEmpty()){
            TreeNode first = qu.poll();
            TreeNode second = qu.poll();
            //if both are null no need to push just skip this traversal using continue
            if(first == null && second == null){
                continue;
            }else if(first == null || second == null || first.val != second.val){
                return false;
            }

            qu.add(first.left);
            qu.add(second.left);
            qu.add(first.right);
            qu.add(second.right);
        }
        return true;
    }
}