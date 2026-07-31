class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for(char ch : word.toCharArray()){
            freq[ch - 'a']++;
        }
        //sort freq array
        Arrays.sort(freq);

        int ans = 0;
        int mult = 1;
        int keyMapped = 0;
        for(int i = 25; i >= 0 && freq[i] > 0; i--){
            int num = freq[i];
            keyMapped++;
            ans = ans + (num * mult);
            if(keyMapped == 8){
                mult++;
                keyMapped = 0;
            }
        }
        return ans;
    }
}

// class Solution {
//     public int minimumPushes(String word) {
//         //creating a hashmap to count frequency of each character
//         HashMap<Character, Integer> map = new HashMap<>();

//         //inserting every character from word into hash with its freq
//         for (char ch : word.toCharArray()) {
//             map.put(ch, map.getOrDefault(ch, 0) + 1);
//         }

//         //SORT HASHMAP USING LIST BASED ON FREQ

//         // converting from hashmap to list
//         List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
//         //sorting descending order
//         list.sort((a, b) -> b.getValue() - a.getValue());
//         int ans = 0;
//         int mult = 1;
//         int keyMapped = 0;
//         for (Map.Entry<Character, Integer> entry : list) {
//             keyMapped++;
//             ans = ans + (entry.getValue() * mult);
//             if(keyMapped == 8){
//                 mult++;
//                 keyMapped = 0;
//             }
//         }
//         return ans;
//     }
// }