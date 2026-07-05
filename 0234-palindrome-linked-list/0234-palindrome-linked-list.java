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
    public boolean isPalindrome(ListNode head) {
        // STEPS
        //first identify lenght (odd or even)
        //find the mid (using slow and fast)
        //if length is even reverse (mid to end) && start comparing reversed mid with start till right end
        //if length is odd reverse (mid + 1  to end ) && start comparing reversed with mid + 1 and start till end

        //how to identify the lenght is odd or even
        // OPTION 1 - traverse and count
        // OPTION 2 - if fast == null then even and if fast.next is null then its odd
        if(head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = null;
        //now slow is pointing to the mid 
        if(fast == null){
            //i am even length
            mid = slow;
        }else{
            //i am odd length
            mid = slow.next;
        }
        ListNode reversed = reverse(mid);

        //now compare reverse with start
        ListNode curr = head;
        while(reversed != null){
            if(curr.val != reversed.val) return false;
            curr = curr.next;
            reversed = reversed.next;
        }
        return true;
    };

    //function to reverse the link list
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}