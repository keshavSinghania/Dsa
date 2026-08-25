class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int ans = 0;
        PriorityQueue<ArrayList<Integer>> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.get(0), b.get(0)));

        //first pick all the element from the all the rows , that is smallest element 
        // from the every row and form heap
        for(int row = 0 ; row < matrix.length; row++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(matrix[row][0]);
            temp.add(row);
            temp.add(0);
            minHeap.offer(temp);
        }

        //now start picking smallest (peek) element and putting next greater element that is next element of that row until you get thw top k element
        while(k > 0){
            ArrayList<Integer> temp = minHeap.poll();
            int value = temp.get(0);
            int row = temp.get(1);
            int col = temp.get(2);

            ans = value;
            k--;

            // put next element of this row
            if(col + 1 >= matrix.length) continue;

            ArrayList<Integer> nextRowEle = new ArrayList<>();
            nextRowEle.add(matrix[row][col + 1]);
            nextRowEle.add(row);
            nextRowEle.add(col + 1);
            minHeap.offer(nextRowEle);
        }
        return ans;
    }
}