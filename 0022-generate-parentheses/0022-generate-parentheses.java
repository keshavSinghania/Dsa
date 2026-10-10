class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        findAns(n, ans, sb);
        return ans;
    }
    //FUNCTION
    public void findAns(int n, List<String> ans, StringBuilder sb){
        //base case
        if(sb.length() == 2 * n){
            String temp = sb.toString();
            ans.add(temp);
            return;
        }

        sb.append('(');
        if(isValid(n, sb)){
            findAns(n, ans, sb);
        }
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        if(isValid(n,sb)){
            findAns(n, ans, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
    //FUNCTION TO CHECK VALID OR NOT
    public boolean isValid(int n, StringBuilder sb){
        int openCount = 0;
        int count = 0;
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '('){
                count++;
                openCount++;
            }else{
                count--;
            }
        }
        if(count >= 0 && openCount <= n){
            return true;
        }
        return false;
    }
}