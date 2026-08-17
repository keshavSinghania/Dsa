class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        if (goal == 0) {
            int count = 0;
            int zeroCount = 0;

            for (int num : nums) {
                if (num == 0) {
                    zeroCount++;
                    count += zeroCount;
                } else {
                    zeroCount = 0;
                }
            }

            return count;
        }
        
        int sum = 0;
        int left = 0;
        int count = 0;
        int zeroCount = 0;
        
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];

            while(left <= right && sum > goal) {
                sum -= nums[left];
                left++;
                zeroCount = 0;
            }

            if(sum == goal){
                while(left < right && nums[left] == 0){
                    zeroCount++;
                    left++;
                }
                count += zeroCount + 1;
            }
        }
        return count;
    }
}