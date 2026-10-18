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
    class Pair{
        int hd;
        TreeNode node;

        Pair(int hd, TreeNode node){
            this.hd = hd;
            this.node = node;
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        int ans = root.val;
        int currHd = 0;
        Queue<Pair> q = new LinkedList<>();;

        q.offer(new Pair(0, root));

        while(!q.isEmpty()){
            Pair peak = q.poll();
            if(currHd != peak.hd){
                currHd = peak.hd;
                ans = peak.node.val;
            }
            if(peak.node.left != null){
                q.offer(new Pair(peak.hd + 1, peak.node.left));
            }
            if(peak.node.right != null){
                q.offer(new Pair(peak.hd + 1, peak.node.right));
            }
        }
        return ans;
    }
}