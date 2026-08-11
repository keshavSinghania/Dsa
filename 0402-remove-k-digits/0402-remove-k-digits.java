class Solution {
    public String removeKdigits(String num, int k) {

        if(num.length() == k) return "0";

        Stack<Character> st = new Stack<>();
        for(char ch : num.toCharArray()) {
            while(!st.isEmpty() && k > 0 && st.peek() - '0' > ch - '0') {
                st.pop();
                k--;
            }
            st.push(ch);
        }

        // If k is still remaining, remove from the end
        while(k > 0) {
            st.pop();
            k--;
        }

        // Convert stack to StringBuilder
        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        // Reverse to get original order
        sb.reverse();

        // Remove leading zeros
        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        if(sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}