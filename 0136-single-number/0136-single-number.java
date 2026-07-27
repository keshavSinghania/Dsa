class Solution {
    public int singleNumber(int[] nums) {
        //XOR of any two same number is always 0 , there XOR all the number you will get that single number
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            ans = nums[i] ^ ans; 
        }
        return ans;
    }
}