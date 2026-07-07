// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) {
//  *         val = x;
//  *         next = null;
//  *     }
//  * }
//  */
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         HashSet<ListNode> set = new HashSet<>();
//         ListNode curr = headA;

//         while(curr != null){
//             set.add(curr);
//             curr = curr.next;
//         }

//         curr = headB;
//         while(curr != null){
//             if(set.contains(curr)){
//                 return curr;
//             }
//             curr = curr.next;
//         }

//         return null;
//     }
// }

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //length of first list
        ListNode curr1 = headA;
        int len1 = 0;
        while(curr1 != null){
            len1++;
            curr1 = curr1.next;
        }

        //length of second list
        ListNode curr2 = headB;
        int len2 = 0;
        while(curr2 != null){
            len2++;
            curr2 = curr2.next;
        }

        int diff = Math.max(len1, len2) - Math.min(len1, len2);

        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        if(len1 >= len2){
            //traverse leng1 to length = diff
            for(int i = 1; i <= diff; i++){
                ptr1 = ptr1.next;
            }
        }else{
            for(int i = 1; i <= diff; i++){
                ptr2 = ptr2.next;
            }
        }

        while(ptr1 != null && ptr2 != null){
            if(ptr1 == ptr2) return ptr1;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return null;
    }
}