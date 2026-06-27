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
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        if(head == null) return head;
        while(curr != null && curr.next != null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        if(head.val == val){
            //remove head
            if(head.next == null){
                head = null;
            }else{
                head = head.next;
            }
        }
        return head;
    }
}