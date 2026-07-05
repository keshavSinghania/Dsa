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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //count the length of list
        int length = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            length++;
        }
        int toDelete = (length - n) + 1;
        if(length < 1) return null;
        return removeNthFromStart(head, toDelete);
    }
    //function to remove nth node from start
    private ListNode removeNthFromStart(ListNode head, int n){
        if(n == 1){
            //if it is first node
            head = head.next;
            return head;
        }

        ListNode curr = head;
        //reaching the node have to delete
        for(int i = 1; i < n; i++){
            if(curr.next.next == null){
                curr.next = null;
                return head;
            }
            curr = curr.next;
        }
        //delete current
        curr.val = curr.next.val;
        curr.next = curr.next.next;
        return head;
    }
}