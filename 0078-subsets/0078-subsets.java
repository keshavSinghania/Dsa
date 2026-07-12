class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        int idx = 0;

        generate(ans, temp, idx, nums);
        return ans;
    }

    //function to generate all the subsets using recurison
    private void generate(List<List<Integer>> ans, List<Integer> temp, int idx, int[] nums){
        if(nums.length == idx){
            //add inside the ans 
            ans.add(new ArrayList<>(temp));
            return;
        }

        // take
        temp.add(nums[idx]);
        generate(ans, temp, idx + 1, nums);

        //remove current and go for not take
        temp.remove(temp.size() - 1);
        generate(ans, temp, idx + 1, nums);
    }
}