class Solution {
    public int minimumPushes(String word) {
        int wordCount = word.length();
        int mult = 1;
        int ans  = 0;
        while(wordCount != 0){
            if(wordCount >= 8){
                ans = ans + (8 * mult);
                wordCount = wordCount - 8;
            }else{
                ans = ans + (wordCount * mult);
                wordCount = 0;
            }
            mult++;
        }
        return ans;
    }
}