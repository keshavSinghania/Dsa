class Solution {
    public boolean checkValidString(String s) {
        //traverse 
        //if '(' push ->st1
        //if '*' push ->st2
        //if ')' then pop from st1 if not empty else from st2 , else false

        //at last if st1 is empty return true, else
        // try to balance using astrick else false

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st1.push(i);
            }else if(ch == '*'){
                st2.push(i);
            }else{
                if(!st1.isEmpty()){
                    st1.pop();
                }else if(!st2.isEmpty()){
                    st2.pop();
                }else{
                    return false;
                }
            }
        }
        while(!st1.isEmpty()){
            if(st2.isEmpty()) return false;
            if(st1.peek() < st2.peek()){
                st1.pop();
                st2.pop();
            }else{
                return false;
            }
        }
        return true;
    }
}