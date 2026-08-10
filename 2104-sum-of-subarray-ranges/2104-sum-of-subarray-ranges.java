class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] nextSmaller = new int[nums.length];
        int[] nextGreater = new int[nums.length];
        int[] prevSmaller = new int[nums.length];
        int[] prevGreater = new int[nums.length];

        // FUNCTION TO FIND THE NEXT SMALLEST ELEMENT INDEX IN THE ARRAY
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nextSmaller[i] = -1;
            } else {
                nextSmaller[i] = st.peek();
            }
            st.add(i);
        }

        // clearing our stack
        st.clear();

        // FUNCTION TO FIND THE NEXT GREATER ELEMENT INDEX IN THE ARRAY
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = st.peek();
            }
            st.add(i);
        }

        // clearing our stack
        st.clear();

        // FUNCTION TO FIND THE PREV SMALLEST ELEMENT
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                prevSmaller[i] = -1;
            } else {
                prevSmaller[i] = st.peek();
            }
            st.add(i);
        }

        // clearing our stack
        st.clear();

        // FUNCTION TO FIND THE PREV GREATER ELEMENT
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                prevGreater[i] = -1;
            } else {
                prevGreater[i] = st.peek();
            }
            st.add(i);
        }

        // clearing our stack
        st.clear();
        
        long minSum = 0;
        long maxSum = 0;
        for(int i = 0; i < nums.length; i++){
            minSum += (long) (i - prevSmaller[i]) *
                      (nextSmaller[i] == -1 ? nums.length - i : nextSmaller[i] - i) *
                      nums[i];

            maxSum += (long) (i - prevGreater[i]) *
                      (nextGreater[i] == -1 ? nums.length - i : nextGreater[i] - i) *
                      nums[i];
        }
        return maxSum - minSum;
    }
}