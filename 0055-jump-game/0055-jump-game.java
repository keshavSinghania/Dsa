class Solution {
    public boolean canJump(int[] nums) {


        int maxIdxCanBeReached = 0;

        for(int i = 0; i < nums.length; i++){
            if(i > maxIdxCanBeReached) return false;
            int maxReachable = i + nums[i];
            maxIdxCanBeReached = Math.max(maxReachable, maxIdxCanBeReached);
            if(maxIdxCanBeReached >= nums.length) return true;
        }
        return true;
    }
}