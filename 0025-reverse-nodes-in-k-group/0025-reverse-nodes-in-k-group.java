class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        ListNode start = head;

        while (start != null) {

            // Find the kth node
            ListNode end = start;
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }

            // Less than k nodes left
            if (end == null) {
                //attaching it to the linked list without reversinggg
                temp.next = start;
                break;
            }

            // Preserve next node
            ListNode nextStart = end.next;

            // Cut current group
            end.next = null;

            // Reverse current group
            ListNode reversedHead = reverse(start);

            // Attach reversed group
            temp.next = reversedHead;

            // Old start becomes the tail
            temp = start;

            // Reconnect with remaining list
            temp.next = nextStart;

            // Move to next group
            start = nextStart;
        }

        return dummy.next;
    }

    // Standard reverse helper
    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}