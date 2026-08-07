// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         final int MOD = 1_000_000_007;
//         int n = arr.length;

//         int[] left = new int[n];
//         int[] right = new int[n];

//         Stack<int[]> st = new Stack<>();

//         // Left counts
//         for (int i = 0; i < n; i++) {
//             int count = 1;
//             while (!st.isEmpty() && arr[st.peek()[0]] > arr[i]) {
//                 count += st.peek()[1];
//                 st.pop();
//             }
//             left[i] = count;
//             st.push(new int[]{i, count});
//         }
//         st.clear();
//         // Right counts
//         // Next Less or Equal
//         for (int i = n - 1; i >= 0; i--) {
//             int count = 1;
//             while (!st.isEmpty() && arr[st.peek()[0]] >= arr[i]) {
//                 count += st.peek()[1];
//                 st.pop();
//             }
//             right[i] = count;
//             st.push(new int[]{i, count});
//         }

//         long ans = 0;
//         for (int i = 0; i < n; i++) {
//             ans = (ans + (long) arr[i] * left[i] * right[i]) % MOD;
//         }

//         return (int) ans;
//     }
// }

import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        Stack<Integer> st = new Stack<>();

        // Previous Smaller Element (Strictly Smaller)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller Element (Smaller or Equal)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nextSmaller[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = 0;
        int MOD = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            long left = i - prevSmaller[i];
            long right = nextSmaller[i] - i;

            ans = (ans + (arr[i] * left * right) % MOD) % MOD;
        }

        return (int) ans;
    }
}