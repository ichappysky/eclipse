package oct15;

public class ValidateSudoku {
	public boolean isValidSudoku(char[][] board) {
		boolean[][] rows = new boolean[9][9];
		boolean[][] cols = new boolean[9][9];
		boolean[][] blocks = new boolean[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				int cur = board[i][j] - '0';
				int numIndex = cur - 1;
				if (rows[i][numIndex]) {
					return false;
				}
				rows[i][numIndex] = true;
				if (cols[j][numIndex]) {
					return false;
				}
				cols[j][numIndex] = true;
				int blockIndex = i / 3 * 3 + j / 3;
				if (blocks[blockIndex][numIndex]) {
					return false;
				}
				blocks[blockIndex][numIndex] = true;
			}
		}
		return true;
	}
}
