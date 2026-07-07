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
    public ListNode sortList(ListNode head) {
        // using merge sort to solve it
        //that is divide and merge

        // BASE CASE
        if(head == null || head.next == null){
            return head;
        }

        //to divide into 2 parts we have to identify mid of it 
        ListNode mid = findMid(head);

        //break it after mid and mid.next will be rightHead;
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode leftHead = head;

        //now we have to 2 half i.e right half and left half , pass both in this function only

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        //now we have new left and right which is sorted , lets merge it
        return merge2Sorted(leftHead, rightHead);
    }

    //function to find the mid //note we have to find mid prev if its even , not next
    private ListNode findMid(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //function to merge two sorted array
    private ListNode merge2Sorted(ListNode head1, ListNode head2){
        ListNode curr1 = head1;
        ListNode curr2 = head2;

        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;

        while(curr1 != null && curr2 != null){
            if(curr1.val <= curr2.val){
                dummy.next = curr1;
                curr1 = curr1.next;
                dummy = dummy.next;
            }else{
                dummy.next = curr2;
                curr2 = curr2.next;
                dummy = dummy.next;
            }
        }

        if(curr1 == null){
            dummy.next = curr2;
        }else{
            dummy.next = curr1;
        }
        return ans.next;
    }
}