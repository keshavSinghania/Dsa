class Solution {
    public int findKthLargest(int[] nums, int k) {
        //init a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            if(pq.size() < k){
                pq.offer(num);
            }else{
                //compare with the peek (smallest element)
                //remove it if that is smaller than the current
                if(pq.peek() < num){
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        return pq.peek();
    }
}