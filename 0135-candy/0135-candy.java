class Solution {
    public int candy(int[] ratings) {
        //mountain approach
        int n = ratings.length;
        int i = 1;
        int sum = 1;
        while(i < n){
            //if same just add 1
            if(ratings[i] == ratings[i - 1]){
                sum += 1;
                i++;
                continue;
            }

            int peak = 1;
            while(i < n && ratings[i - 1] < ratings[i]){
                peak++;
                i++;
                sum += peak;
            }
            int slope = 0;
            while(i < n && ratings[i] < ratings[i- 1]){
                slope++;
                i++;
                sum += slope;
            }
            slope++;
            if(slope > peak){
                sum += slope - peak;
            }
        }
        return sum;
    }
}