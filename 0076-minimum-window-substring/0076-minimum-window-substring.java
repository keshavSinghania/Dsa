class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> stringFreq = new HashMap<>();

        int left = 0;
        int count = 0;
        int minLength = s.length() + 1;
        int[] ans = new int[2];

        for (char ch : t.toCharArray()) {
            stringFreq.put(ch, stringFreq.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            //if positive then count++
            if (stringFreq.containsKey(ch) && stringFreq.get(ch) > 0) {
                count++;
            }

            //decrease the freq of current chracter by -1 , if present
            if (stringFreq.containsKey(ch)) {
                stringFreq.put(ch, stringFreq.get(ch) - 1);
            }

            //if window is valid , start sliding the window from left to get min desired length
            while (count == t.length()) {

                //length of the current valid window
                int length = i - left + 1;

                if (length < minLength) {
                    ans[0] = left;
                    ans[1] = length;
                    minLength = length;
                }

                // Remove left character from the window
                char leftChar = s.charAt(left);

                if (stringFreq.containsKey(leftChar)) {
                    //increasing the freq of chracter we just removed form left side
                    stringFreq.put(leftChar,stringFreq.get(leftChar) + 1);

                    // If frequency becomes > 0 then decrease count
                    if (stringFreq.get(leftChar) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }

        // No valid window found
        if (minLength == s.length() + 1) {
            return "";
        }

        return s.substring(ans[0], ans[0] + ans[1]);
    }
}