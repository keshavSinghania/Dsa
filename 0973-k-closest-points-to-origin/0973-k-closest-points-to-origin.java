class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //Index and Distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[1],a[1]));

        for(int i = 0; i < points.length; i++){
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if(maxHeap.isEmpty()){
                maxHeap.offer(new int[]{i, dist});
            }else if(maxHeap.size() == k){
                if(maxHeap.peek()[1] > dist){
                    maxHeap.poll();
                    maxHeap.offer(new int[]{i, dist});
                }
            }else{
                maxHeap.offer(new int[]{i, dist});
            }
        }

        int ans[][] = new int[k][2];
        int idx = 0;
        while(!maxHeap.isEmpty()){
            ans[idx++] = points[maxHeap.poll()[0]];
        }
        return ans;
    }
}

// formula changes to ----> root of (x square  + y square)
