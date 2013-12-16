package oct07;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [ ["ABCE"], ["SFCS"], ["ADEE"] ]
 * 
 * word = "ABCCED", -> returns true, word = "SEE", -> returns true, word =
 * "ABCB", -> returns false.
 * 
 * @author yongz
 * 
 */
public class HelpWordSearch {
	final int NON_EXISTING_CHAR = 277;

	public boolean exist(char[][] board, String word) {
		if (board == null || word == null) {
			return false;

		}
		if (word.length() == 0) {
			return true;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char ch = board[i][j];
				if (ch == word.charAt(0)
						&& helper(board, i, j, word.substring(1))) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean helper(char[][] board, int row, int col, String word) {
		if (word.length() == 0) {
			return true;
		}
		char savedChar = board[row][col];
		char targetChar = word.charAt(0);
		if (row > 0 && board[row - 1][col] == targetChar) {
			board[row][col] = NON_EXISTING_CHAR;
			// go up
			if (helper(board, row - 1, col, word.substring(1))) {
				return true;
			}
			board[row][col] = savedChar;
		}
		if (row < board.length - 1 && board[row + 1][col] == targetChar) {
			board[row][col] = NON_EXISTING_CHAR;
			// go down
			if (helper(board, row + 1, col, word.substring(1))) {
				return true;
			}
			board[row][col] = savedChar;
		}
		if (col > 0 && board[row][col - 1] == targetChar) {
			board[row][col] = NON_EXISTING_CHAR;
			// go left
			if (helper(board, row, col - 1, word.substring(1))) {
				return true;
			}
			board[row][col] = savedChar;
		}
		if (col < board[0].length - 1 && board[row][col + 1] == targetChar) {
			board[row][col] = NON_EXISTING_CHAR;
			// go left
			if (helper(board, row, col + 1, word.substring(1))) {
				return true;
			}
			board[row][col] = savedChar;
		}
		return false;
	}
}
