class Solution {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        // let me solve this using brute force
        for(int i = 0; i < nums.length; i++){
            int smallestElement = nums[i];
            int largestElement = nums[i];
            for(int j = i; j < nums.length; j++){
                if(smallestElement > nums[j]){
                    smallestElement = nums[j];
                }else if(largestElement < nums[j]){
                    largestElement = nums[j];
                }

                //we have updated smallest and largest element
                ans += (largestElement - smallestElement);
            }
        }
        return ans;
    }
}