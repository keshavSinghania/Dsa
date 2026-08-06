class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[][] prevNextSmaller = new int[n][2];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Find next smaller for popped elements
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int idx = st.pop();
                prevNextSmaller[idx][1] = i;
            }

            // Find previous smaller for current element
            if (st.isEmpty()) {
                prevNextSmaller[i][0] = -1;
            } else {
                prevNextSmaller[i][0] = st.peek();
            }

            st.push(i);
        }

        // Remaining elements have no next smaller
        while (!st.isEmpty()) {
            prevNextSmaller[st.pop()][1] = n;
        }

        // at this point we have next smallest and prevSmallest index of every index
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            int dist = prevNextSmaller[i][1] - prevNextSmaller[i][0] - 1;
            maxArea = Math.max(maxArea, heights[i] * dist);
        }
        return maxArea;
    }
}

// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int area = 0;
//         for(int i = 0; i < heights.length; i++){
//             int smallestHeight = heights[i];
//             for(int j = i; j < heights.length; j++){
//                 if(heights[j] < smallestHeight){
//                     smallestHeight = heights[j];
//                 }
//                 int dist = j - i + 1;
//                 int currentArea = dist * smallestHeight;
//                 area = Math.max(area, currentArea);
//             }
//         }
//         return area;
//     }
// }