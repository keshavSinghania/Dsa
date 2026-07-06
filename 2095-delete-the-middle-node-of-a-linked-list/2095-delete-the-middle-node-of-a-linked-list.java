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
    public ListNode deleteMiddle(ListNode head) {

        ListNode curr = head;
        //first reach mid node
        
        //first identify n that is size of list
        int n = 0;
        while(curr != null){
            n++;
            curr = curr.next;
        };

        //some edge cases
        if(n == 1 || n == 0){
            ListNode temp = null;
            return temp;
        }
        int toDeleteIndex = n/2;

        ListNode toDeletePrev = head;
        for(int i = 0; i < toDeleteIndex - 1; i++){
            toDeletePrev = toDeletePrev.next;
        }
        toDeletePrev.next = toDeletePrev.next.next;
        return head;
    }
}