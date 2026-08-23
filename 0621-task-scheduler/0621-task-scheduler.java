class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        //counting freq of every character
        for(char task : tasks){
            freq[task - 'A']++;
        }

        //final the maximum freq in our freq array
        int maxFreq = 0;
        for(int i = 0; i < freq.length; i++){
            maxFreq = Math.max(maxFreq, freq[i]);
        }

        //now count the nummber of time max element is coming
        int maxFreqCount = 0;
        for(int i = 0 ; i < freq.length; i++){
            if(freq[i] == maxFreq) maxFreqCount++;
        }
        int temp = maxFreq + (maxFreq - 1) * n + (maxFreqCount - 1);
        return Math.max(tasks.length, temp);
    }
}