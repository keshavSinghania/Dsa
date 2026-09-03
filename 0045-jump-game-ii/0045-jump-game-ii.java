class Solution {
    public int jump(int[] nums) {
        int toReach = nums.length - 1;
        int possibleIdx = -1;
        int jump = 0;
        if(nums.length == 1) return 0;
        if(nums.length == 0) return 0;
        while(true){
            for(int j = toReach - 1; j >= 0; j--){
                int dist = toReach - j;
                if(dist <= nums[j]){
                    possibleIdx = j;
                }
            }
            toReach = possibleIdx;
            jump++;
            if(toReach == 0) return jump;
        }
    }
}