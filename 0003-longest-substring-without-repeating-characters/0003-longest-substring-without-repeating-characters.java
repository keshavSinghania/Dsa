class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int ptr1 = 0;
        int maxLength = 0;
        int length = 0;
        for(int ptr2 = 0; ptr2 < s.length(); ptr2++){
            while(set.contains(s.charAt(ptr2))){
                set.remove(s.charAt(ptr1));
                ptr1++;
                length--;
            }
            set.add(s.charAt(ptr2));
            length++;
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }
}