class Solution {
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 0) {
                ans <<= 1;
            } else {
                ans = (ans << 1) | 1;
            }
            n >>>= 1; 
        }

        return ans;
    }
}