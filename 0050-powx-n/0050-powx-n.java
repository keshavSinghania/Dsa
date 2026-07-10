class Solution {
    public double myPow(double x, long n) {
        boolean isNegative = false;
        if(n < 0){
            isNegative = true;
            n = -1 * n;
        }

        double ans = 1.0;

        while(true){
        if(n == 0){
            if(isNegative){
                ans = 1 / ans;
            }
            return ans;
        }
        
        //if our power is odd then simply multiply our answer with that number(x) and decrease the power(n) by 1
        if(n % 2 != 0){
            //multiplying with ans
            ans *= x;
            //decreasing n by 1
            n--;
        }else{
            //if power is even, then divide power(n) by 2 and multiply number(x) by itself
            n /=  2;
            x *= x;
        }
        }
    }
}