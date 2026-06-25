class Solution {
    public int maxDepth(String s) {
        int paranCount = 0;
        int ans = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                paranCount++;
                ans = Math.max(ans, paranCount);
            }else if(c == ')'){
                paranCount--;
            }
        }
        return ans;
    }
}