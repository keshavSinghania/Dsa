class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int area = 0;
        // make a histogram for all the row
        int heights[] = new int[matrix[0].length];
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                int curr = matrix[row][col] - '0';
                if(curr == 0){
                    heights[col] = 0;
                }else{
                    heights[col] += 1;
                }
            }
            area = Math.max(largestRectangleArea(heights), area);
        }
        return area;
    }
    private int largestRectangleArea(int[] heights) {
        //for every height finf enxt adn prev smaller and next smaller
        int[] prevSmaller = new int[heights.length];
        int[] nextSmaller = new int[heights.length];

        Stack<Integer> st = new Stack<>();

        //function to find the next smaller
        for(int i = heights.length - 1; i >= 0; i--){
            int curr = heights[i];
            while(!st.isEmpty() && heights[st.peek()] >= curr){
                st.pop();
            }
            if(!st.isEmpty()){
                nextSmaller[i] = st.peek();
            }else{
                nextSmaller[i] = heights.length;
            }
            st.push(i);
        }

        st.clear();
        //function to find all the prevSmaller elements
        for(int i = 0; i < heights.length; i++){
            int curr = heights[i];
            while(!st.isEmpty() && heights[st.peek()] >= curr){
                st.pop();
            }
            if(!st.isEmpty()){
                prevSmaller[i] = st.peek();
            }else{
                prevSmaller[i] = -1;
            }
            st.push(i);
        }

        //now we have prev and next smaller of each heights
        int area = 0;
        for(int i = 0; i < heights.length; i++){
            int height = heights[i];
            int width = nextSmaller[i] - prevSmaller[i] - 1;

            area = Math.max(area, height * width);
        }
        return area;
    }
}