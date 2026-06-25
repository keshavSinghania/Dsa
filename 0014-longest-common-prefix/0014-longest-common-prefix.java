class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        //compare first and last
        String first = strs[0];
        String last = strs[strs.length - 1];
        StringBuilder ans = new StringBuilder();

        int length = Math.min(first.length(), last.length());
        for(int i = 0; i < length; i++){
            if(first.charAt(i) == last.charAt(i)){
                ans.append(first.charAt(i));
            }else{
                return ans.toString();
            }
        }
        return ans.toString();
    }
}