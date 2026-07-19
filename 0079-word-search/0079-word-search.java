class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //check for every first path path
                if (board[i][j] == word.charAt(0)) {
                    if (dfsRecursively(board, word, 0, i, j))
                        return true;
                }
            }
        }
        return false;
    }

    //function
    private boolean dfsRecursively(char[][] board, String word, int idx, int i, int j) {
        //if already found the word return true
        if (idx == word.length() - 1)
            return true;

        //mark current as # before traversing (so that we would not able to traverse this again)
        char originalChar = board[i][j];
        board[i][j] = '#';

        //traversing and passing in dfsRecursively to check further path

        //checking if possible to move up

        //FOR UP -> i - 1
        if (i > 0 && board[i - 1][j] == word.charAt(idx + 1)) {
            if (dfsRecursively(board, word, idx + 1, i - 1, j))
                return true;
        }

        //FOR DOWN -> i + 1
        if (i + 1 < board.length && board[i + 1][j] == word.charAt(idx + 1)) {
            if (dfsRecursively(board, word, idx + 1, i + 1, j))
                return true;
        }

        //FOR RIGHT -> j + 1
        if (j + 1 < board[0].length && board[i][j + 1] == word.charAt(idx + 1)) {
            if (dfsRecursively(board, word, idx + 1, i, j + 1))
                return true;
        }

        //FOR LEFT -> j - 1
        if (j > 0 && board[i][j - 1] == word.charAt(idx + 1)) {
            if (dfsRecursively(board, word, idx + 1, i, j - 1))
                return true;
        }

        //backtrack
        board[i][j] = originalChar;

        // checked all the direction not found return false
        return false;
    }
}