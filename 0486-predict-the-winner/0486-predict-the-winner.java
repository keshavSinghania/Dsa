class Solution {
    public boolean predictTheWinner(int[] nums) {
        return winner(nums, 0, nums.length - 1) >= 0;
    }

    //function to find if player 1 is winner or not
    private int winner(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int pickLeft = nums[start] - winner(nums, start + 1, end);
        int pickRight = nums[end] - winner(nums, start, end - 1);

        return Math.max(pickLeft, pickRight);
    }
}