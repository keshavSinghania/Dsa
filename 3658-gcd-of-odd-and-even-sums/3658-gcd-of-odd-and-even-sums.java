class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumE = sumEven(n);
        int sumO = sumOdd(n);
        return gcd(sumE, sumO);
    }

    //find the sum of first n odd number
    private int sumOdd(int n) {
        int odd = 1;
        int currentSum = 0;
        for (int i = 1; i <= n; i++) {
            odd = odd + 2;
            currentSum = currentSum + odd;

        }
        return currentSum;
    }
    private int sumEven(int n) {
        int even = 2;
        int currentSum = 0;
        for (int i = 1; i <= n; i++) {
            even = even + 2;
            currentSum = currentSum + even;
        }
        return currentSum;
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}