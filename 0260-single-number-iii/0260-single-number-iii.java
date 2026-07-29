class Solution {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        int bucket1 = 0;
        int bucket2 = 0;

        for(int num : nums){
            sum ^= num;
        }
        //assuming our single number is a and b
        //here we will end with sum = a ^ b;
        //now- > for sure one of bit must be different is both a and b because both are different num ( a != b)
        //find out that , that mean find out that last bit index which contains set bit
        //now make two buckets
        //bucket1 = > traverse whole array and store all the number with upper index == set bit
        //bucket2 = > traverse whole array and store all the number with upper index != set bit

        //now xor all the values of bucket1 and bucket 2
        //as our both the ans ( a and b) will be in different buckets because of different bit
        //return bucket 1 and bucket 2

        //make a mask which contains most last 1 with corresponding 0
        // eg: 1110110100  ==> 0000000100 //extract this ... formula mask = sum & (-sum);
        int mask = sum & (-sum); //-sum => 2s complement
        for(int num: nums){
            if((num & mask) != 0){
                bucket1 ^= num;
            }else{
                bucket2 ^= num;
            }
        }      
        return new int[]{bucket1, bucket2};
    }
}