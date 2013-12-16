package search;

public class WordSearch {
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

	private boolean helper(char[][] board, int r, int c, String word) {
		if (word.length() == 0) {
			return true;
		}
		char savedChar = board[r][c];
		char targetChar = word.charAt(0);
		if (r > 0 && board[r - 1][c] == targetChar) {
			board[r][c] = NON_EXISTING_CHAR;
			// go up
			if (helper(board, r - 1, c, word.substring(1))) {
				return true;
			}
			board[r][c] = savedChar;
		}
		if (r < board.length - 1 && board[r + 1][c] == targetChar) {
			board[r][c] = NON_EXISTING_CHAR;
			// go down
			if (helper(board, r + 1, c, word.substring(1))) {
				return true;
			}
			board[r][c] = savedChar;
		}
		if (c > 0 && board[r][c - 1] == targetChar) {
			board[r][c] = NON_EXISTING_CHAR;
			// go left
			if (helper(board, r, c - 1, word.substring(1))) {
				return true;
			}
			board[r][c] = savedChar;
		}
		if (c < board[0].length - 1 && board[r][c + 1] == targetChar) {
			board[r][c] = NON_EXISTING_CHAR;
			// go left
			if (helper(board, r, c + 1, word.substring(1))) {
				return true;
			}
			board[r][c] = savedChar;
		}
		return false;
	}
}
