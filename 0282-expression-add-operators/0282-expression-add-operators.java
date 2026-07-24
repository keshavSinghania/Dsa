class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        StringBuilder exp = new StringBuilder();
        dfs(num, target, ans, exp, 0, 0);
        return ans;
    }

    private void dfs(String num, int target, List<String> ans, StringBuilder exp, long total, long prevOperand) {
        //BASE CASE
        if (num.length() == 0) {
            if (total == target) {
                ans.add(exp.toString());
            }
            return;
        }

        //HANDLE LEADING ZERO
        for (int i = 1; i <= num.length(); i++) {

            String curr = num.substring(0, i);
            String newNum = num.substring(i);

            if (curr.length() > 1 && curr.charAt(0) == '0')
                break;

            long currVal = Long.parseLong(curr);

            //HANDLE FIRST (WHERE NO PREV OPERAND EXISTS) (EXPRESSON IS EMPTY)
            if (exp.length() == 0) {
                int len = exp.length();
                exp.append(curr);
                dfs(newNum, target, ans, exp, currVal, currVal);
                exp.setLength(len);
            } else {
                int len = exp.length();

                //ADDITION
                exp.append("+");
                exp.append(curr);
                dfs(newNum, target, ans, exp, total + currVal, currVal);
                exp.setLength(len);

                //SUBSTRACTION
                exp.append("-");
                exp.append(curr);
                dfs(newNum, target, ans, exp, total - currVal, -currVal);
                exp.setLength(len);

                //MULTIPLICATION
                exp.append("*");
                exp.append(curr);
                long newTotal = total - prevOperand + (prevOperand * currVal);
                long newPrevOperand = prevOperand * currVal;
                dfs(newNum, target, ans, exp, newTotal, newPrevOperand);
                exp.setLength(len);
            }
        }
    }
}