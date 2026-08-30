class Solution {
    public int minimumDeletions(int[] nums) {
        int[] min = new int[]{nums[0], 0};
        int[] max = new int[]{nums[0], 0};

        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(min[0] > curr){
                min[0] = curr;
                min[1] = i;
            }
            if(max[0] < curr){
                max[0] = curr;
                max[1] = i;
            }
        }

        int minIdx = min[1];
        int maxIdx = max[1];

        int front = Math.max(minIdx, maxIdx) + 1;
        int back = nums.length - Math.min(minIdx, maxIdx);
        int both = (Math.min(minIdx, maxIdx) + 1) + (nums.length - Math.max(minIdx, maxIdx));

        return Math.min(Math.min(front,back),both);
    }
}