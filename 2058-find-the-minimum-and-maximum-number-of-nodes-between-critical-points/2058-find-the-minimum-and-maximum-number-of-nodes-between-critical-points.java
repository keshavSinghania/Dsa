/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> criticalPoints = new ArrayList<>();
        criticalPoints = findCriticalPoints(head);
        if(criticalPoints.isEmpty() || criticalPoints.size() == 1){
            return new int[]{-1, -1};
        }

        int[] ans = new int[2];
        ans[1] = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);

        int minDist = criticalPoints.get(1) - criticalPoints.get(0) ;
        for(int i = 0; i < criticalPoints.size() - 1; i++){
            minDist = Math.min(minDist, criticalPoints.get(i + 1) - criticalPoints.get(i));
        }
        ans[0] = minDist;
        return ans;
    }
    //function to find the index of all the critical points in node
    private ArrayList<Integer> findCriticalPoints(ListNode head){
        ArrayList<Integer> list = new ArrayList<>();
        
        //traversing the linked list and finding the critical points
        ListNode curr = head;
        ListNode prev = curr;
        curr = curr.next;
        int idx = 1;
        while(curr.next != null){
            if((prev.val < curr.val) && (curr.val > curr.next.val)){
                list.add(idx);
            }else if(prev.val > curr.val && curr.val < curr.next.val){
                list.add(idx);
            }
            idx++;
            prev = curr;
            curr = curr.next;
        }
        return list;
    }
}