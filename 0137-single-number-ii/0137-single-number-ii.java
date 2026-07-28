class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int setBitCount = 0;
            for(int num : nums){
                if((num & (1 << i)) != 0) setBitCount++;
            }
            if(setBitCount % 3 != 0){
                //add one at bit index i
                ans = ans | (1 << i);
            }
        }
        return ans;
    }
}

//idea 
// take all the number and write thier bits,
// now start from back and count number of 1s bit at last position ,
// if that is multiple of 3 then add then our ans last bit will be 0 else 1
// do this for all the last bit till 32 
