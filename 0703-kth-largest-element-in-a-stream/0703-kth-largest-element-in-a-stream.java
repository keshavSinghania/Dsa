class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        
        // Keep only the k largest elements
        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {

        minHeap.offer(val);

        // Remove the smallest among the k+1 elements
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // Smallest element in the heap = kth largest overall
        return minHeap.peek();
    }
}