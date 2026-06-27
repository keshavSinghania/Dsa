class MyLinkedList {
    //own datatype declaration
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }
    //variable with my data type
    ListNode head;
    //to contain size
    int size;

    //constructor to declare a new linked list
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    //different functions to perform different tasks
    public int get(int index) {
        if (index < 0 || index > size) return -1;
        //storing head into curr , so that can move it freely
        ListNode curr = head;

        for(int i = 0; i < index; i++){
            curr = curr.next;
        }
        if (curr == null) return -1;
        return curr.val;
    }
    
    public void addAtHead(int val) {
        //create a new node 
        ListNode curr = new ListNode(val);
        curr.next = head;
        head = curr;
        size++;
    }
    
    public void addAtTail(int val) {
        //create a new node
        ListNode newNode = new ListNode(val);

        //if empty link list
        if(head == null){
            head = newNode;
            size++;
            return;
        }
        ListNode curr = head;
        //travese till end
        while(curr.next != null){
            curr = curr.next;
        }
        //now curr is pointing towards last node
        //simply add new node location inti
        curr.next = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        //theory
        //if you want to add at particular index . first traverse just before that index
        //create a new link node 
        //add adress of next node in new node i.e newNode.next = curr.next;
        //now add inside curr node change next pointer address to new node i.e curr.next = newNode

        if(index < 0 || index > size) return;
        //at head
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }

        //creating a new node
        ListNode newNode = new ListNode(val);

        //travesing till just before the give index
        ListNode curr = head;
        for(int i = 0; i < index - 1; i++){
            curr = curr.next;
        }

        //curr is that node after which we have to add new node
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        //reach index you wanna delete
        if(index < 0 || index >= size) return;
        
        //deleting if its a head
        if(index == 0){
            head = head.next;
            size--;
            return;
        }

        ListNode curr = head;

        // move to (index - 1)
        for(int i = 0; i < index - 1; i++){
            curr = curr.next;
        }

         curr.next = curr.next.next;
         size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */