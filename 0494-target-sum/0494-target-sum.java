class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int currIdx = 0;
        int currSum = 0;

        return countIt(nums, target, currIdx, currSum);
    }

    //fucntion to count total
    private int countIt(int[] nums, int target, int currIdx, int currSum){
        if(currIdx == nums.length){
            return (currSum == target) ? 1 : 0;
        }

        // taking + 1
        currSum += nums[currIdx];
        int add =  countIt(nums, target, currIdx + 1, currSum);

        //taking - 1. but before that removing that +1
        currSum -= nums[currIdx];
        currSum -= nums[currIdx];
        int sub = countIt(nums, target, currIdx + 1, currSum);
        return add + sub;
    }
}