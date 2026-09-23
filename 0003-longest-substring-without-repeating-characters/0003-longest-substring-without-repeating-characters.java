class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        for(int right = 0; right < s.length(); right++){
            char rightChar = s.charAt(right);
            char leftChar = s.charAt(left);
            if(!set.contains(rightChar)){
                set.add(rightChar);
            }else{
                while(set.contains(rightChar)){
                    set.remove(leftChar);
                    left++;
                    leftChar = s.charAt(left);
                }
                set.add(rightChar);
            }
            int count = right - left + 1;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}