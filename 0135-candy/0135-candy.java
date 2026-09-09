class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        left[0] = 1;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i-1] >= ratings[i]){
                left[i] = 1;
            }else{
                left[i] = left[i - 1] + 1;
            }
        }
        right[ratings.length - 1] = 1;
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] <= ratings[i + 1]){
                right[i] = 1;
            }else{
                right[i] = right[i + 1] + 1;
            }
        }

        //finding max of both
        int totalCandy = 0;
        for(int i = 0; i < ratings.length; i++){
            totalCandy += Math.max(left[i],right[i]);
        }
        return totalCandy;
    }
}