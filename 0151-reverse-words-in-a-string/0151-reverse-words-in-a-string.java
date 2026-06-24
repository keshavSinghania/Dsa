class Solution {

    public String reverseWords(String s) {
        StringBuilder temp = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                temp.append(s.charAt(i));
            }else{
                if(temp.length() > 0){
                     if (ans.length() > 0) {
                        ans.append(' ');
                    }
                    temp.reverse();
                    ans.append(temp);
                    temp.setLength(0);
                }
            }
        }
         if (temp.length() > 0) {
            if (ans.length() > 0) {
                ans.append(' ');
            }
            ans.append(temp.reverse());
        }
        return ans.toString();
    }
}