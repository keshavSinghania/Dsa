class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int idx = 0;
        int currSum = 0;

        find(candidates, target, ans, temp, idx, currSum);
        return ans;
    }
    //function
    private void find(int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp, int idx, int currSum){
        if(currSum > target){
            return;
        }
        if(currSum == target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(idx == candidates.length){
            return;
        }

        //take + increase currentSum
        temp.add(candidates[idx]);
        find(candidates, target, ans, temp, idx + 1, currSum + candidates[idx]);

        //remove current and then pass withour current 
        //before taking must avoid not dupliactes
        temp.remove(temp.size() - 1);
        while(idx + 1 < candidates.length && candidates[idx] == candidates[idx+1]){
            //skip 
            idx++;
        }
        find(candidates, target, ans, temp, idx + 1, currSum);
    }
}