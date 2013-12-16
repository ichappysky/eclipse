public class SudokuSolver {
	private boolean[][] rows;
	private boolean[][] cols;
	private boolean[][] blocks;

	public void solveSudoku(char[][] board) {
		rows = new boolean[9][9];
		cols = new boolean[9][9];
		blocks = new boolean[9][9];
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				char c = board[i][j];
				if (c != '.') {
					int curNumIndex = c - '1';
					rows[i][curNumIndex] = true;
					cols[j][curNumIndex] = true;
					blocks[(i / 3) * 3 + j / 3][curNumIndex] = true;
				}
			}
		}
		helper(board, 0);
	}

	private boolean helper(char[][] board, int count) {
		// find next .
		while (count < 81 && board[count / 9][count % 9] != '.') {
			count++;
		}
		// full board. job is done
		if (count == 81) {
			return true;
		}

		int row = count / 9, col = count % 9;
		for (int i = 0; i < 9; ++i) {
			// number has been used
			if (rows[row][i] || cols[col][i]
					|| blocks[(row / 3) * 3 + col / 3][i]) {
				continue;
			}
			rows[row][i] = true;
			cols[col][i] = true;
			blocks[(row / 3) * 3 + col / 3][i] = true;
			
			board[row][col] = Character.forDigit(i + 1, 10);
			
			if (helper(board, count + 1)) {
				return true;
			}
			board[row][col] = '.';
			rows[row][i] = false;
			cols[col][i] = false;
			blocks[(row / 3) * 3 + col / 3][i] = false;
		}

		return false;
	}
}