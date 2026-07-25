class Solution {
    public int maxProduct(int n) {
        //sort and pick last two
        int max = -1;
        int secMax = -1;
        while(n > 0){
            int digit = n % 10;
            if(max < digit){
                secMax = max;
                max = digit;
            }else if(secMax < digit){
                secMax = digit;
            }
            n = n / 10;
        }
        return max * secMax;
    }
}