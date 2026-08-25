class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        // [value][freq]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //loop over hashmap
        for(int key : map.keySet()){
            maxHeap.offer(new int[]{key, map.get(key)});
        }
        int idx = 0;
        while(k > 0){
            ans[idx++] = maxHeap.poll()[0];
            k--;
        }

        return ans;
    }
}