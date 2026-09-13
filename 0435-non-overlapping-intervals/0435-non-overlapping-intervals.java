class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int ans = 0;
        int n = intervals.length;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < n; i++){
            int start1 = intervals[i][0];
            int end1 = intervals[i][1];

            //checking if overlapping
            if(end > start1){
                //fixing overlapping
                ans++;
                //choosing prev and removing current ith element
                if(end1 < end){
                    start = start1;
                    end = end1;
                }
            }else{
                start = start1;
                end = end1;
            }
        }

        return ans;
    }
}