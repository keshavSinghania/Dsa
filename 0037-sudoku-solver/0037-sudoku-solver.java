class Solution {
    public void solveSudoku(char[][] board) {
        if (solveMe(board, 0, 0))
            return;
        return;
    }

    //function to solve sudoko
    private boolean solveMe(char[][] board, int row, int col) {
        //if this is out of bond cell that means we have got out ans
        if (row == 9 && col == 0)
            return true;

        // if current cell already has some pre existing value pass for next
        int newRow = row;
        int newCol = col + 1;
        if (newCol == 9) {
                newRow++;
                newCol = 0;
            }
        if (board[row][col] != '.') {
            if (solveMe(board, newRow, newCol)) {
                return true;
            }
            return false;
        }
        //check for every possible value from 0 to 9 and pass for that value
        for (int i = 1; i <= 9; i++) {
            if (isPossible(board, row, col, i)) {
                //write this value and pass to check for next
                board[row][col] = (char) (i + '0');
                if (solveMe(board, newRow, newCol))
                    return true;
                //else backtrack
                board[row][col] = '.';
            }
        }
        return false;
    }

    //function to check is this possible or not
    private boolean isPossible(char[][] board, int row, int col, int val) {
        //checking rows that is row 0 to 8
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == (char) (val + '0'))
                return false;
        }
        //checking col that is col 0 to 8
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == (char) (val + '0'))
                return false;
        }

        //checking own 3 x 3 area
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for(int roww = startRow; roww < startRow + 3; roww++){
            for(int coll = startCol; coll < startCol + 3; coll++){
                if(board[roww][coll] == (char) (val + '0')) return false;
            }
        }
        return true;
    }
}