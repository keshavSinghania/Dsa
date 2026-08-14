class LRUCache {
    private int capacity;

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);

            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            curr.next = head.next;
            curr.prev = head;

            head.next.prev = curr;
            head.next = curr;

            return curr.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);

            // Update value
            curr.value = value;

            // Remove curr from current position
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            // Move curr to MRU
            curr.next = head.next;
            curr.prev = head;

            head.next.prev = curr;
            head.next = curr;

        } else {
            // If cache is full, remove LRU
            if (map.size() == capacity) {
                Node curr = tail.prev;

                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;

                map.remove(curr.key);
            }

            // Create new node
            Node curr = new Node(key, value);

            // Insert at MRU position
            curr.next = head.next;
            curr.prev = head;

            head.next.prev = curr;
            head.next = curr;

            // Add to map
            map.put(key, curr);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */