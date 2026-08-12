class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();


        for (int i = 0; i < k; i++) {
            // Remove all smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }
            // Add current index
            dq.addLast(i);
        }
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;
        ans[idx++] = nums[dq.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            int prevIdx = i - k;

            // If the outgoing element was peak remove it
            if (!dq.isEmpty() && dq.peekFirst() == prevIdx) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            ans[idx++] = nums[dq.peekFirst()];
        }
        return ans;
    }
}