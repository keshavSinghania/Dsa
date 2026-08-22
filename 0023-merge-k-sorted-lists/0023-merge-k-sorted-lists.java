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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue <ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));

        ListNode ans = new ListNode();
        ListNode temp = ans;

        for(int i = 0; i < lists.length; i++){
            ListNode currHead = lists[i];
            if(lists[i] != null){
                pq.offer(lists[i]);
            }
        }

        while(pq.size() != 0){
            //remove peek and store its value
            ListNode top = pq.poll();
            
            //if next node exists in this list then add that 
            if(top.next != null){
                pq.offer(top.next);
                top.next = null;
            }
            temp.next = top;
            temp = temp.next;
        }

        return ans.next;
    }
}