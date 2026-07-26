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
    public ListNode partition(ListNode head, int x) {
        ListNode lesserThanHead = new ListNode(0);
        ListNode greaterThanOrEqualHead = new ListNode(0);

        ListNode lesserThan = lesserThanHead;
        ListNode greaterThanOrEqual = greaterThanOrEqualHead;

        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;

            if (curr.val < x) {
                lesserThan.next = curr;
                lesserThan = lesserThan.next;
            } else {
                greaterThanOrEqual.next = curr;
                greaterThanOrEqual = greaterThanOrEqual.next;
            }

            curr.next = null; // Break old link
            curr = next;
        }

        // Merge the two lists
        lesserThan.next = greaterThanOrEqualHead.next;

        return lesserThanHead.next;
    }
}