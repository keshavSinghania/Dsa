class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int card : hand){
            minHeap.offer(card);
        }

        int currentSize = 0;
        int currentElement = -1;
        while(!minHeap.isEmpty()){
            if(currentSize == groupSize){
                currentSize = 0;
            }
            boolean added = false;
            ArrayList<Integer> temp = new ArrayList<>();
            if(currentSize == 0){
                currentElement = minHeap.poll();
                added = true;
            }else{
                while(!minHeap.isEmpty()){
                    int heapPeak = minHeap.poll();
                    if(heapPeak == currentElement + 1){
                        added = true;
                        currentElement++;
                        break;
                    }else{
                        temp.add(heapPeak);
                    }
                }
            }
            if(!added){
                    return false;
                }else{
                    for(int ele : temp){
                        minHeap.offer(ele);
                    }
                    currentSize++;
                }
        }
        return true;
    }
}

//number of hand should be multiple of groupsize , else return false
//now we knows for sure all the element can be rearrange in the form of group (to return true)
//sort them , start from the smallest element ,make group check if next element is same  ignore that and then pick consective..
//any moment it is not consecutive return false..
//we will use min heap for that