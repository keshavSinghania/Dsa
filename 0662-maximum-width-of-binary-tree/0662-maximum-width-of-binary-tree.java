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
    public class Pair{
        TreeNode node;
        int idx;

        //constructor
        Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        if(root == null) return 0;

        //rightMostIdx - leftMostIdx + 1
        q.offer(new Pair(root, 1));
        int maxWidth = 1;

        while(!q.isEmpty()){
            int size = q.size();

            int leftMost = -1;
            int rightMost = -1;
            for(int i = 0; i < size; i++){
                Pair top = q.poll();
                if(top.node != null){
                    if(leftMost == -1){
                        leftMost = top.idx;
                    }
                    rightMost = top.idx;
                    q.offer(new Pair(top.node.left, 2 * top.idx));
                    q.offer(new Pair(top.node.right, 2 * top.idx + 1));
                }
            }
            int width = rightMost - leftMost + 1;
            maxWidth = Math.max(width, maxWidth);
        }
        return maxWidth;
    }
}