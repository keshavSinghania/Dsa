class Solution {
    public String smallestPalindrome(String s) {
        int[] charMap = new int[26];
        StringBuilder sb = new StringBuilder();
        StringBuilder mid = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            charMap[idx]++;
        }
        for (int i = 0; i < charMap.length; i++) {
            int count = charMap[i];
            char ch = (char) ('a' + i);

            while (count != 0) {
                if (count == 1) {
                    mid.append(ch);
                    count--;
                } else if (count >= 2) {
                    sb.append(ch);
                    count -= 2;
                }
            }
        }
        StringBuilder end = new StringBuilder(sb).reverse();
        sb.append(mid).append(end);
        return sb.toString();
    }
}