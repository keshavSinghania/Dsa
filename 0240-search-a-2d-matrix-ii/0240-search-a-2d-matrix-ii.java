class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //start from top right corner
        // if value == target return
        // if value > then move left //To move left do col--
        //else move down //To move down row++

        int row = 0;
        int col = matrix[0].length - 1;
        while(row != matrix.length && col != -1){
            int value = matrix[row][col];
            if(value == target){
                return true;
            }else if(value > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}