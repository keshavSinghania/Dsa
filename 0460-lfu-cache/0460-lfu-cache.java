
class LFUCache {

    class Node {
        int key;
        int value;
        int freq;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLL {
        Node head;
        Node tail;

        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        // Add node immediately after head
        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        // Remove any node
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Remove least recently used node
        Node removeLast() {
            Node node = tail.prev;
            remove(node);
            return node;
        }

        boolean isEmpty() {
            return head.next == tail;
        }
    }

    // key → Node
    HashMap<Integer, Node> mapKey;

    // frequency → DLL
    HashMap<Integer, DLL> mapFreq;

    int capacity;
    int minFreq;

    private void increaseFrequency(Node currNode) {

        int currFreq = currNode.freq;

        DLL currDLL = mapFreq.get(currFreq);

        currDLL.remove(currNode);

        // If old minimum frequency became empty
        if (currFreq == minFreq && currDLL.isEmpty()) {
            minFreq++;
        }

        currNode.freq++;

        int newFreq = currNode.freq;

        DLL newFreqDLL = mapFreq.get(newFreq);

        if (newFreqDLL == null) {
            newFreqDLL = new DLL();
            mapFreq.put(newFreq, newFreqDLL);
        }

        newFreqDLL.addFirst(currNode);
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;

        mapKey = new HashMap<>();
        mapFreq = new HashMap<>();
    }

    public int get(int key) {

        if (!mapKey.containsKey(key)) {
            return -1;
        }

        Node currNode = mapKey.get(key);

        increaseFrequency(currNode);

        return currNode.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // Case 1: key already exists
        if (mapKey.containsKey(key)) {

            Node currNode = mapKey.get(key);

            currNode.value = value;

            increaseFrequency(currNode);

            return;
        }

        // Case 2: cache is full
        if (mapKey.size() == capacity) {

            DLL minFreqDLL = mapFreq.get(minFreq);

            Node removedNode = minFreqDLL.removeLast();

            mapKey.remove(removedNode.key);
        }

        // Case 3: new key
        Node newNode = new Node(key, value);

        mapKey.put(key, newNode);

        DLL freqOneDLL = mapFreq.get(1);

        if (freqOneDLL == null) {
            freqOneDLL = new DLL();
            mapFreq.put(1, freqOneDLL);
        }

        freqOneDLL.addFirst(newNode);

        minFreq = 1;
    }
}