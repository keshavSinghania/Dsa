class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        // ..loop to find max and min
        int max = nums[0];
        int min = nums[0];
        for(int num : nums){
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
        }

        //loop to identify missing elements
        for(int i = min; i <= max; i++){
            if(!isPresent(nums, i)){
                ans.add(i);
            }
        }
        return ans;
    }
    //to checl present or not
    private boolean isPresent(int[] nums, int key){
        for(int num : nums){
            if(key == num) return true;
        }
        return false;
    }
}