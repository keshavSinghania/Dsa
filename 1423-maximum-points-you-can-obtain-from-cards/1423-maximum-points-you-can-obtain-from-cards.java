class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int p = cardPoints.length - k;
        int sum  = 0;
        int left = 0;
        int right = 0;
        int minSum = 0;

        for(; right < p; right++){
            sum += cardPoints[right];
        }
        minSum = sum;

        for(; right < cardPoints.length; right++){
            sum -= cardPoints[left++];
            sum += cardPoints[right];
            minSum = Math.min(sum, minSum);
        }

        //total sum of subarray
        int totalSum = 0;
        for(int i =0; i < cardPoints.length; i++){
            totalSum += cardPoints[i];
        }

        return totalSum - minSum;
    }
}