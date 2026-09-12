class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        ArrayList<int[]> ans = new ArrayList<>();
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int start1 = intervals[i][0];
            int end1 = intervals[i][1];
            if(end < start1){
                ans.add(new int[]{start, end});
                start = start1;
                end = end1;
            }else{
                //merge 
                end = Math.max(end, end1);
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][2]);
    }
}