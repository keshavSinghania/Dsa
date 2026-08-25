class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] sortedStrs = new String[strs.length];

        for(int i = 0; i < strs.length; i++){
            char[] chArray = strs[i].toCharArray();
            Arrays.sort(chArray);
            String temp = new String(chArray);
            sortedStrs[i] = temp;
        }

        // [String][List of Strings]
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for(String temp : sortedStrs){
            map.put(temp, new ArrayList<String>());
        }

        for(int i = 0; i < strs.length; i++){
            map.get(sortedStrs[i]).add(strs[i]);
        }

        List<List<String>> ans = new ArrayList<>();
        for(List<String> group : map.values()){
            ans.add(group);
        }

        return ans;
    }
}