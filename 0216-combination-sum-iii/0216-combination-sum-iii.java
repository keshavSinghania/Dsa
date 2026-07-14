class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //how to find all the combination of 3 digits from [1,2,3,4,5,6,7,8,9]
        //generate all again till 9th index take only if 3 digits and == sum
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int idx = 0;
        int sum = 0;
        generate(nums, k, n, ans, temp, idx, sum);
        return ans;
    }

    //main function 
    private void generate(int[] nums, int maxLen, int target, List<List<Integer>> ans, List<Integer> temp, int idx,
            int sum) {
        //special optimization i.e if sum > target , on increasing further sum will only increase so stop
        if (temp.size() > maxLen || sum > target) {
            return;
        }
        if (idx == 9) {
            if (temp.size() == maxLen && sum == target) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        //if size is == len
        if (temp.size() == maxLen && sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        //take 
        temp.add(nums[idx]);
        generate(nums, maxLen, target, ans, temp, idx + 1, sum + nums[idx]);

        //remove temp and send for donot take
        temp.remove(temp.size() - 1);
        generate(nums, maxLen, target, ans, temp, idx + 1, sum);
    }
}