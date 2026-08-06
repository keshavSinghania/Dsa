class Solution {
    public int smallestNumber(int n, int t) {
        // we are sure product digits any number btw n to n + 10 ,will be divisible with all the number btw 1 to 10

        for (int i = 0; i < 10; i++) {
            int current = n + i;
            int num = current;
            int product = 1;
            while (num > 0) {
                product = product * (num % 10);
                num = num / 10;
            }
            if (product % t == 0)
                return current;
        }
        return -1;
    }
}