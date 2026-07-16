class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        backtrack(s,partition, 0, ans);
        return ans;
    }
    //function to divide into different part till last only if palindrome and store in answer
    private void backtrack(String s, List<String> partition, int startIdx, List<List<String>> ans){
        if(startIdx == s.length()){
            //no more partition possible
            //and if we are able to divide it till last after checking palindrome for sure this is 
            // one of our ans
            ans.add(new ArrayList<>(partition));
            return;
        }

        //start dividing in every possible way
        //if palindrom possible in that way divide further by passing in same function 
        //or stop of that partition check for next
        for(int i = startIdx; i < s.length(); i++){
            if(isPalindrome(s, startIdx, i)){
                // ex:aab
                // first for a|
                // then for aa|
                //send for further partition but before that store this
                partition.add(s.substring(startIdx, i + 1));
                //this time start point will be just after where we divided it
                backtrack(s, partition, i + 1, ans);
                //remove last if that not possible or already store final ans
                partition.remove(partition.size() - 1);
            }
        }
    }
    //function to check palindrome or not
    private boolean isPalindrome(String s, int start , int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}