class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        //putting the elements that comes before the new intervals
        while(i < n && intervals[i][1] < newInterval[0]){
            ans.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        //now putting new element and merging if needed
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // adding this new interval
        ans.add(newInterval);

        //now putting rest intervals into ans
        while(i < n){
            ans.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        //converting array list into array and returning
        return ans.toArray(new int[ans.size()][2]);
    }
}