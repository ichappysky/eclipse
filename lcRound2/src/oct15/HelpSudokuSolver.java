package oct15;

public class HelpSudokuSolver {
	public void solveSudoku(char[][] board) {
		boolean[][] rows = new boolean[9][9];
		boolean[][] cols = new boolean[9][9];
		boolean[][] blocks = new boolean[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				int numIndex = board[i][j] - '1';
				int blockIndex = i - i % 3 + j / 3;
				rows[i][numIndex] = true;
				cols[j][numIndex] = true;
				blocks[blockIndex][numIndex] = true;
			}
		}

		helper(board, rows, cols, blocks, 0);

	}

	private boolean helper(char[][] board, boolean[][] rows, boolean[][] cols,
			boolean[][] blocks, int count) {
		while (count < 81 && board[count / 9][count % 9] != '.') {
			count++;
		}
		if (count == 81) {
			return true;
		}
		int row = count / 9;
		int col = count % 9;
		int block = row / 3 * 3 + col / 3;
		for (int i = 0; i < 9; i++) {

			if (rows[row][i] || cols[col][i] || blocks[block][i]) {
				continue;
			}
			rows[row][i] = true;
			cols[col][i] = true;
			blocks[block][i] = true;
			board[row][col] = Character.forDigit(i + 1, 10);
			if (helper(board, rows, cols, blocks, count + 1)) {
				return true;
			}
			board[row][col] = '.';
			rows[row][i] = false;
			cols[col][i] = false;
			blocks[block][i] = false;
		}
		return false;
	}

}
