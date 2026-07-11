class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans =  new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        //to make it stop inside recursion
        int openCount = 0;
        int closeCount = 0;
        find(ans, temp, openCount, closeCount, n);
        return ans;
    }
    private void find(List<String> ans, StringBuilder temp, int openCount, int closeCount, int n){
            //when the count of both is equal to n
            if(openCount == n && closeCount == n){
                ans.add(temp.toString());
                return;
            }

            //add open paranthesis
            if(openCount != n){
                temp.append('(');
                find(ans, temp, openCount + 1, closeCount, n);
            //remove open paran and then pass for close paran
                temp.deleteCharAt(temp.length() - 1);
            }
            if(openCount > closeCount){
                temp.append(')');
                find(ans, temp, openCount, closeCount + 1, n);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
}