class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int noOfSubsets = 1 << nums.length;

        // go from 0 to noOfSubsets - 1, and for 0 take and for 1 not take
        for(int i = 0; i < noOfSubsets; i++){
            //always check for nums.length bits only
            List<Integer> temp = new ArrayList<>();
            int mask = i;
            for(int idx = 0; idx < nums.length; idx++){
                //start checking bits of i from back if 1 then put that index value or not put
                if((mask & 1) != 0){
                    temp.add(nums[idx]);
                }
                //right shift i by 1
                mask = mask >> 1;
            }
            ans.add(new ArrayList(temp));
        }
        return ans;
    }
}