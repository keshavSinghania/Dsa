/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = null;
        if(root == null) return ans;
        List<TreeNode> pathOfP = new ArrayList<>();
        List<TreeNode> pathOfQ = new ArrayList<>();
        findPath(root, p, pathOfP);
        findPath(root, q, pathOfQ);

        int max = Math.min(pathOfP.size(), pathOfQ.size());
        //now find the depthest 
        for(int i = 0; i < max; i++){
            if(pathOfP.get(i).val == pathOfQ.get(i).val){
                ans = pathOfP.get(i);
            }else{
                break;
            }
        }
        return ans;
    }

    //function to find the path till x element in tree
    public static boolean findPath(TreeNode root , TreeNode target, List<TreeNode> path){
        if(root == null){
            return false;
        }
        //adding current path(assuming the current path goes to the target)
        path.add(root);

        if(root.val == target.val){
            return true;
        }

        //checking if else has element or right has
        if(findPath(root.left, target, path) || findPath(root.right, target, path)){
            return true;
        }

        //remove current path as this path is incorrect
        path.remove(path.size() - 1);
        return false;
    }
}