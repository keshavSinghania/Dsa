class Solution {
    public int largestRectangleArea(int[] heights) {
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