class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //first push all the rows into the heap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));

        for(int row = 0; row < nums1.length; row++){
            int sum = nums1[row] + nums2[0];
            minHeap.offer(new int[]{row, 0, sum});
        }
        List<List<Integer>> ans = new ArrayList<>();
        while(ans.size() != k){
            int[] peek = minHeap.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[peek[0]]);
            temp.add(nums2[peek[1]]);
            ans.add(temp);

            //push next element of that row who just poped out
            int newCol = peek[1] + 1;
            if(newCol < nums2.length){
                //push this new col of same row
                int sum = nums1[peek[0]] + nums2[newCol];
                minHeap.offer(new int[]{peek[0], newCol, sum});
            }
        }
        return ans;
    }
}

//                  nums2
//               2       9       10      15
//            ┌───────┬───────┬───────┬───────┐
// nums1 = 1  │ (1,2) │ (1,9) │(1,10) │(1,15) │
//            ├───────┼───────┼───────┼───────┤
//        = 7 │ (7,2) │ (7,9) │(7,10) │(7,15) │
//            ├───────┼───────┼───────┼───────┤
//       = 11 │(11,2) │(11,9) │(11,10)│(11,15) │
//            ├───────┼───────┼───────┼───────┤
//       = 16 │(16,2) │(16,9) │(16,10)│(16,15) │
//            └───────┴───────┴───────┴───────┘