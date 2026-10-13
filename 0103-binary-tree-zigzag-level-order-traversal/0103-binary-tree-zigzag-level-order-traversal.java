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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null){
            return ans;
        }
        List<Integer> tem = new ArrayList<>();
        tem.add(root.val);
        ans.add(tem);
        q.offer(root);
        boolean isReverse = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode currPeak = q.poll();
                if(currPeak.left != null){
                    temp.add(currPeak.left.val);
                    q.offer(currPeak.left);
                }
                if(currPeak.right != null){
                    temp.add(currPeak.right.val);
                    q.offer(currPeak.right);
                }
            }
            if(isReverse){
                Collections.reverse(temp);
            }
            isReverse = !isReverse;
            if(!temp.isEmpty()) ans.add(temp);
        }
        return ans;
    }
}