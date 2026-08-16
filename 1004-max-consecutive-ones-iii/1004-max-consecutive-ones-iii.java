class Solution {
    public int longestOnes(int[] nums, int k) {
        int onceCount = 0;
        int maxCount = 0;
        int count = 0;
        int ptr1 = 0;
        for(int ptr2 = 0; ptr2 < nums.length; ptr2++){
            while(k == 0 && nums[ptr2] == 0){
                if(nums[ptr1] == 1){
                    onceCount--;
                }else{
                    k++;
                }
                count--;
                ptr1++;
            }

            if(nums[ptr2] == 1){
                onceCount++;
                count++;
            }else{
                k--;
                count++;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}