class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        //first sort it 
        Arrays.sort(arr);
        int uniqueCount = 1;
        arr[0] = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i-1]){
                uniqueCount++;
                arr[i] = uniqueCount;
            }
        }
        return uniqueCount;
    }
}