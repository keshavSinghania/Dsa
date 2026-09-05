class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] smallestNext = new int[nums.length];
        int min = nums[nums.length - 1];
        for(int i = nums.length - 1; i >=0; i--){
            if(min > nums[i]){
                min = nums[i];
            }
            smallestNext[i] = min;
        }

        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            int instability = max - smallestNext[i];
            if(instability <= k) return i;
        }

        return -1;
    }
}