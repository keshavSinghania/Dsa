class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        int openCount = 0;
        int count = 0;
        findAns(n, ans, sb, openCount, count);
        return ans;
    }
    //FUNCTION
    public void findAns(int n, List<String> ans, StringBuilder sb, int openCount, int count){
        //base case
        if(openCount == n && count ==0){
            String temp = sb.toString();
            ans.add(temp);
            return;
        }

        sb.append('(');
        openCount++;
        count++;
        if(count >= 0 && openCount <= n){
            findAns(n, ans, sb, openCount, count);
        }
        sb.deleteCharAt(sb.length() - 1);
        count--;
        openCount--;

        sb.append(')');
        count--;
        if(count >= 0 && openCount <= n){
            findAns(n, ans, sb, openCount, count);
        }
        sb.deleteCharAt(sb.length() - 1);
        count++;
    }
    //FUNCTION TO CHECK VALID OR NOT
    // public boolean isValid(int n, StringBuilder sb){
    //     int openCount = 0;
    //     int count = 0;
    //     for(int i = 0; i < sb.length(); i++){
    //         if(sb.charAt(i) == '('){
    //             count++;
    //             openCount++;
    //         }else{
    //             count--;
    //         }
    //     }
    //     if(count >= 0 && openCount <= n){
    //         return true;
    //     }
    //     return false;
    // }
}