class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0; i < ans.length; i ++){
            ans[i] = countBit(i);
        }
        return ans;
    }
    //function to calculate the number of bit in any number
    private int countBit(int n){
        int count = 0;
        while(n != 0){
            //check the bit of 0th index if its i increase count then right shift , else only right shift
            if((n & 1) == 1) count++;
            n = n >> 1;
        }
        return count;
    }
}