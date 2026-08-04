class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        // Phase 1:
        // Build the monotonic stack using the copied part
        // (equivalent to traversing the virtual circular array)
        for (int i = n - 2; i >= 0; i--) {

            // Remove all elements that cannot be the next greater
            while (!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }

            st.push(nums[i]);
        }

        // Phase 2:
        // Process the original array from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Maintain decreasing monotonic stack.
            while (!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }

            // Stack top is the next greater element.
            ans[i] = st.isEmpty() ? -1 : st.peek();

            // Current element may become the answer for elements on its left.
            st.push(nums[i]);
        }

        return ans;
    }
}

// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         Stack<Integer> st = new Stack<>();
//         int[] ans = new int[nums.length];
//         int n = nums.length;
           
//             // back to first
//             for(int k = n - 2; k >= 0; k--){
//                 if(st.isEmpty()){
//                     st.push(nums[k]);
//                 }else if(nums[k] < st.peek()){
//                     st.push(nums[k]);
//                 }else{
//                     //pop untill empty or not found
//                     while(!st.isEmpty() && nums[k] >= st.peek()){
//                         st.pop();
//                     }
//                     st.push(nums[k]);
//                 }
//             }

//             //final to find ans
//             for(int p = n - 1; p >= 0; p--){
//                 if(st.isEmpty()){
//                     ans[p] = -1;
//                 }else if(nums[p] < st.peek()){
//                     ans[p] = st.peek();
//                     st.push(nums[p]);
//                 }else{
//                     while(!st.isEmpty() && nums[p] >= st.peek()){
//                         st.pop();
//                     }
//                     if(st.isEmpty()){
//                         ans[p] = -1;
//                         st.push(nums[p]);
//                     }else{
//                         ans[p] = st.peek();
//                         st.push(nums[p]);
//                     }
//                 }
//             }
//         return ans;
//     }
// }