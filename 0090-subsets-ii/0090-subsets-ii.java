class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int idx = 0;
        generate(nums, idx, ans , temp);
        return ans;
    }
    //function to generate only unique subsets
    private void generate(int[] nums, int idx, List<List<Integer>> ans, List<Integer> temp){
        if(nums.length == idx){
            //add this temp into ans 
            ans.add(new ArrayList<>(temp));
            return;
        }

        //take it
        temp.add(nums[idx]);
        generate(nums, idx + 1, ans, temp);

        //removing added value in temp
        temp.remove(temp.size() - 1);
        
        //sending for not take only if its not unique 
        while(idx + 1 < nums.length && nums[idx] == nums[idx + 1]){
            idx++;
        }
        generate(nums, idx + 1, ans, temp);
    }
}