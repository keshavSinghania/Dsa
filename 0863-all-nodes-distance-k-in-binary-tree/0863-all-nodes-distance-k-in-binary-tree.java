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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        //Task 1: save the parent node of all the nodes with parent(using map for this)
        Map<TreeNode, TreeNode> mapWithParent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode top = q.poll();
            if(top.left != null){
                mapWithParent.put(top.left, top);
                q.offer(top.left);
            }
            if(top.right != null){
                mapWithParent.put(top.right, top);
                q.offer(top.right);
            }
        }
        // End of task 1, we have all the nodes with thier perent nodes marked

        Set<TreeNode> visited = new HashSet<>();
        findDistanceK(k, mapWithParent, visited, target, 0, ans);
        return ans;
    }

    //function to find node with distance k and store its value in ans list
    public static void findDistanceK(int k , Map<TreeNode, TreeNode> parentMap, Set<TreeNode> visited, TreeNode currNode, int dist, List<Integer> ans){
        //first mark current node as visited
        visited.add(currNode);
        //check if distance is k then add all the current node into the ans and return
        if(dist == k){
            if(currNode != null){{
                ans.add(currNode.val);
                return;
            }}
        }

        //check all the three direction if direction possible then traverse at that direction if not traversed
        
        //left direction
        if(currNode.left != null && !visited.contains(currNode.left)){
            findDistanceK(k ,parentMap, visited, currNode.left, dist + 1, ans);
        }
        //right direction
        if(currNode.right != null && !visited.contains(currNode.right)){
            findDistanceK(k ,parentMap, visited, currNode.right, dist + 1, ans);
        }
        //top direction
        if(parentMap.containsKey(currNode)){
            TreeNode topNode = parentMap.get(currNode);
            if(!visited.contains(topNode)){
            findDistanceK(k ,parentMap, visited, topNode, dist + 1, ans);
          }
        }
    }
}