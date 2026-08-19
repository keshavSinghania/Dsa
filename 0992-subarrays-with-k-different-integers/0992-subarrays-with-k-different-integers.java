class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        //Exactly K = At Most K - At Most K - 1
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    //function to calculate at most k element as subarray
    public int atMostK(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.size() > k && left <= right){
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}