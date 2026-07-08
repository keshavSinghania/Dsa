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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        int carry = 0;
        while(curr1 != null || curr2 != null){
            int l1Val = 0;
            int l2Val = 0;
            if(curr1 != null){
                l1Val = curr1.val;
                curr1 = curr1.next;
            }
            if(curr2 != null){
                l2Val = curr2.val;
                curr2 = curr2.next;
            }

            //now we have carry , l2Val , l1Val
            int sum = carry + l1Val + l2Val;
            if(sum > 9){
                sum = sum % 10;
                carry = 1;
            }else{
                carry = 0;
            }

            //add this sum node to the ans
            ListNode addList = new ListNode(sum);
            temp.next = addList;
            temp = temp.next;
        }
        if(carry == 1){
            ListNode addList = new ListNode(1);
            temp.next = addList;
        }
        return ans.next;
    }
}