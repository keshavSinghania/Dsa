class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int digitsLow = countDigits(low);
        int digitsHigh = countDigits(high);
        //to maintain overflow to 10 for 100000000
        digitsHigh = Math.min(digitsHigh, 9);

        List<Integer> ans = new ArrayList<>();

        //run a loop from digitsLow to digitsHigh
        for(int i = digitsLow; i <= digitsHigh; i++){
            // i is number of digit
            StringBuilder temp1 = new StringBuilder();
            StringBuilder temp2 = new StringBuilder();
            for(int k = 1; k <= i; k++){
                temp1.append(k);
                temp2.append(1);
            }
            int start = Integer.parseInt(temp1.toString());
            int toAdd = Integer.parseInt(temp2.toString());
            int temp = 10 - i;
            for(int j = 1; j <= temp; j++ ){
                //this will run a loop same number of time, number of possible seqence for this array
                if(start >= low && start <= high){
                    ans.add(start);
                }
                if(start > high){
                    break;
                }
                start = start + toAdd;
            }
        }
        return ans;
    }
    private int countDigits(int num){
        int count = 0;
        while(num != 0){
            num = num / 10;
            count++;
        }
        return count;
    }
}