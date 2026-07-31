class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                //put in the stack
                st.push(ch);
            } else {
                if (st.isEmpty() || getOpposite(st.peek()) != ch)
                    return false;

                st.pop();
            }
        }
        return st.isEmpty();
    }

    private char getOpposite(char ch) {
        switch (ch) {
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
            default:
                return '#';
        }
    }
}