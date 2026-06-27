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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;

        //storing previous node inside prev [initially it will store prev as null , as it is null for sure]
        ListNode prev = null;

        //run till last node
        while(curr != null){
            //we have to make curr points to the prev ,[if we do this node next curr will be lost]
            //to prevent loss , will save next 
            ListNode next = curr.next;

            //now we can point curr to the prev
            curr.next = prev;

            //now will store curr into prev and move curr to the next
            prev = curr;
            curr = next;
        }
        return prev;
    }
}