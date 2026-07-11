class Solution {
    //to use this variable globally
    static final long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        boolean nowEven = true;
        boolean nowPrime = false;

        //oh you cannot run a loop n times sorry
        long evenCount = (n + 1) / 2;
        long primeCount = n / 2;

        //now have to find 
        // 5^evenCount * 4^oddCount
        long ans = (pow(5, evenCount) * pow(4, primeCount)) % MOD;
        return (int) ans;
    }
    //function to calculate power of something
    long pow(long num, long power) {
    if (power == 0) {
        return 1;
    }

    long half = pow(num, power / 2);

    if (power % 2 == 0) {
        return (half * half) % MOD;
    } else {
        return (num * half * half) % MOD;
    }
}
}