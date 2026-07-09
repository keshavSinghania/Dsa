/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node,Node> map = new HashMap<>();

        Node original = head;
        Node dummy = new Node(original.val);
        Node duplicate = dummy;

        while(original != null){
            //store in hashmap
            map.put(original, duplicate);

            if (original.next != null) {
               duplicate.next = new Node(original.next.val);
               duplicate = duplicate.next;
            }
            original = original.next;
        }
        //now assign random pointer correctly
        Node originalHead = head;
        Node copiedHead = dummy;

        while(originalHead != null){
            copiedHead.random = map.get(originalHead.random);
            copiedHead = copiedHead.next;
            originalHead = originalHead.next;
        }
        return dummy;
    }
}