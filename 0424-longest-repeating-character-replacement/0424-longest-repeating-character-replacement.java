class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int maxLength = 0;
        int ptr1 = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int ptr2 = 0; ptr2 < s.length(); ptr2++){
            //add current character in map or increase freq
            char currChar = s.charAt(ptr2);
            map.put(currChar, map.getOrDefault(currChar,0) + 1);
            int freq = map.get(currChar);
            maxFreq = Math.max(freq, maxFreq);

            int currLength = ptr2 - ptr1 + 1;
            int kUsed = currLength - maxFreq;
            while(kUsed > k){
                map.put(s.charAt(ptr1), map.get(s.charAt(ptr1)) -1);
                ptr1++;
                currLength = ptr2 - ptr1 + 1;
                kUsed = currLength - maxFreq;
            }
            maxLength = Math.max(currLength, maxLength);
        }
        return maxLength;
    }
}