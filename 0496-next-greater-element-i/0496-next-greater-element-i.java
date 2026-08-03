class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //to store ans
        int ans[] = new int[nums1.length];

        //to store the next greater element of every element of nums1
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int num2 : nums2){
            //if stack is empty
            if(st.isEmpty()){
                st.push(num2);
            }else if(st.peek() > num2){
                st.push(num2);
            }else{
                //pop untill peek is not empty or smaller
                while(!st.isEmpty() && st.peek() < num2){
                    //pop and mkae pair
                    map.put(st.pop(), num2);
                }
                //put current elemetn in stack as well
                st.push(num2);
            }
        }
        //our map is ready
        for(int i = 0 ; i < nums1.length; i++){
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}