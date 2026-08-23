class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;

        HashMap<Integer,Integer> freq = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            if(freq.containsKey(hand[i])){
                freq.put(hand[i], freq.get(hand[i]) + 1);
            }else{
                minHeap.offer(hand[i]);
                freq.put(hand[i], 1);
            }
        }

        while(!minHeap.isEmpty()){
            //pick the first element and find consective one , if not found return false
            int min = minHeap.poll();
            freq.put(min, freq.get(min) - 1);
            if(freq.get(min) == 0){
                freq.remove(min);
            }else{
                minHeap.offer(min);
            }
            for(int i = 1; i < groupSize; i++){
                int current = min + i;
                if(!freq.containsKey(current)){
                    return false;
                }else{
                    freq.put(current, freq.get(current) - 1);
                    if(freq.get(current) == 0){
                        freq.remove(current);
                        minHeap.remove(current);
                    }
                }
            }
        }
        return true;
    }
}