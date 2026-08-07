class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1_000_000_007;
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<int[]> st = new Stack<>();

        // Left counts
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!st.isEmpty() && arr[st.peek()[0]] > arr[i]) {
                count += st.peek()[1];
                st.pop();
            }
            left[i] = count;
            st.push(new int[]{i, count});
        }
        st.clear();
        // Right counts
        // Next Less or Equal
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!st.isEmpty() && arr[st.peek()[0]] >= arr[i]) {
                count += st.peek()[1];
                st.pop();
            }
            right[i] = count;
            st.push(new int[]{i, count});
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) arr[i] * left[i] * right[i]) % MOD;
        }

        return (int) ans;
    }
}