import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        // Special case for 1s
        if (map.containsKey(1)) {
            int ones = map.get(1);
            ans = (ones % 2 == 1) ? ones : ones - 1;
        }

        for (int num : nums) {
            if (num == 1) continue;
            ans = Math.max(ans, check(num, map));
        }

        return (ans % 2 == 0) ? ans - 1 : ans ;
    }

    private int check(int num, HashMap<Integer, Integer> map) {
        long curr = num;
        int length = 0;

        while (true) {

            if (curr > 1_000_000_000L) {
                return length;
            }

            int freq = map.getOrDefault((int) curr, 0);

            if (freq >= 2) {
                length += 2;
                curr = curr * curr;

            } else if (freq == 1) {
                return length + 1;

            } else {
                return length - 1;
            }
        }
    }
}