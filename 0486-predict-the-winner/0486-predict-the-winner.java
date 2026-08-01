class Solution {
    public boolean predictTheWinner(int[] nums) {
        return winner(nums, 0, nums.length - 1, 0, 0, true) >= 0;
    }

    private int winner(int[] nums, int left, int right,
            int p1Score, int p2Score, boolean p1Turn) {

        if (left > right) {
            return p1Score - p2Score;
        }

        if (p1Turn) {
            return Math.max(
                    winner(nums, left + 1, right,
                            p1Score + nums[left], p2Score, false),
                    winner(nums, left, right - 1,
                            p1Score + nums[right], p2Score, false));
        } else {
            return Math.min(
                    winner(nums, left + 1, right,
                            p1Score, p2Score + nums[left], true),
                    winner(nums, left, right - 1,
                            p1Score, p2Score + nums[right], true));
        }
    }
}