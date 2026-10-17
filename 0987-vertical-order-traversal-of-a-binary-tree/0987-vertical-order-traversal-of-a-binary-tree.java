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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int row = 0;
        int col = 0;
        List<int[]> list = new ArrayList<>();
        //traversing the whole nodes of the tree
        traverseTree(list, root, row , col);

        //now sort this list first based on row and then col and then val
        list.sort((a,b) -> {
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[2],b[2]);
        });

        List<List<Integer>> ans = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for(int[] node : list){
            int co = node[1];
            int val = node[2];

            if(co != prevCol){
                ans.add(new ArrayList<>());
                prevCol = co;
            }
            ans.get(ans.size()-1).add(val);
        }
        return ans;
    }
    //function to traverse the nodes of the tree
    public static void traverseTree(List<int[]> list, TreeNode root, int row , int col){
        //base case
        if(root == null){
            return;
        }
        //add current inside the map
        list.add(new int[]{row, col, root.val});

        //left => row++ and col--
        traverseTree(list, root.left, row + 1, col - 1);

        //right => row++ and col ++
        traverseTree(list, root.right, row + 1, col + 1);
    }
}