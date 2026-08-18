class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int prefixSum = 0;
        int count = 0;

        for(int num : nums){
            //if odd put 1 and if even put 0
            prefixSum += (num % 2);
            count += map.getOrDefault(prefixSum - k, 0);
            //update map
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}