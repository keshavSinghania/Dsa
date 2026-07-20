class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0, ans);

        return ans;
    }

    private void solve(char[][] board, int row, List<List<String>> ans) {

        // All queens placed
        if (row == board.length) {

            List<String> temp = new ArrayList<>();

            for (char[] currentRow : board) {
                temp.add(new String(currentRow));
            }

            ans.add(temp);
            return;
        }

        // Try placing queen in every column of current row
        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                // Place Queen
                board[row][col] = 'Q';

                // Recurse for next row
                solve(board, row + 1, ans);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {

        // Check upper column
        for (int r = row - 1; r >= 0; r--) {
            if (board[r][col] == 'Q')
                return false;
        }

        // Check upper-left diagonal
        int r = row - 1;
        int c = col - 1;

        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q')
                return false;

            r--;
            c--;
        }

        // Check upper-right diagonal
        r = row - 1;
        c = col + 1;

        while (r >= 0 && c < board.length) {
            if (board[r][c] == 'Q')
                return false;

            r--;
            c++;
        }

        return true;
    }
}