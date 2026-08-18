class Solution {
    public int numberOfSubstrings(String s) {
        //total nums of substrings - total nums pp substring that doesnot contains a b c = ans;
        int n = s.length();
        long totalNumOfSubstring = 1L * n * (n + 1) / 2;

        long totalNumNoABC = 0;
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            if(s.charAt(right) == 'a'){
                countA++;
            }else if(s.charAt(right) == 'b'){
                countB++;
            }else{
                countC++;
            }
            while (countA > 0 && countB > 0 && countC > 0) {
                if (s.charAt(left) == 'a') {
                    countA--;
                } else if (s.charAt(left) == 'b') {
                    countB--;
                } else {
                    countC--;
                }
                left++;
            }
            totalNumNoABC += right - left + 1;
        }
        return (int) (totalNumOfSubstring - totalNumNoABC);
    }
}