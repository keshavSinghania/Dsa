/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 //given:
 //given node is not last
 //all the values are unique
 //have to delete given node
class Solution {
    public void deleteNode(ListNode node) {
        //copy next element
        //then mark curr.next that is pointer equal to the the pointer of next

        node.val = node.next.val;
        node.next = node.next.next;
        
    }
}