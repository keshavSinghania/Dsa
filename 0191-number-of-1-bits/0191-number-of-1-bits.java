class Solution {
    public int hammingWeight(int n) {
        //have to calculate the number of bits

        //identify right bit and then right shift it , repeat untill it becomes == 0
        //how to identify last bit => if i perform and operation that is current and 1 , then if that 
        //come up to be all zero that means last one was 0 else 1
        int count = 0;
        while(n != 0){
            //check last bit and increase count if it is 1
            if((n & 1) != 0) count++;
            //right shift by 1
            n = n >> 1;
        }
        return count;
    }
}
//Brian Kernighan's Algorithm
// 11 = > 1011
// 10 =>  1010

// 40 => 101000
// 39 => 100111
//    &  --------
//       100000 (you remove one 1 from the last , do i becomes 0)