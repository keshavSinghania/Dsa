class Solution {
    public int beautySum(String s) {
        int sum = 0;

        for(int i = 0; i < s.length(); i++){
            int[] freq = new int[26];
            for(int j = i; j < s.length(); j++){
                char temp = s.charAt(j);
                freq[temp - 'a']++;
                //counting min and max
                int max = 0;
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < freq.length; k++){
                    max = Math.max(max, freq[k]);
                    if(freq[k] > 0){
                        min = Math.min(min, freq[k]);
                    }
                }
                sum += (max - min);
            }
        }
        return sum;
    }
}