class Solution {
    public int jump(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return 0;
        }
        int lastJumpIndex = 0;
        int totalJump = 0;
        int currentMax = nums[0];

        for(int i = 0; i < nums.length - 1; i++){
            currentMax = Math.max(currentMax, i + nums[i]);
            if(lastJumpIndex == i){
                lastJumpIndex = currentMax;
                totalJump++;
            }
        }
        return totalJump;
    }
}