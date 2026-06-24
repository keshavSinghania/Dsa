class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int openCount = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                if(openCount == 0){
                    openCount++;
                }else{
                    openCount++;
                    ans.append(c);
                }
            }else if(c == ')'){
                openCount--;
                if(openCount != 0){
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    }
}