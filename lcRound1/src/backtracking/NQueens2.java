package backtracking;
public class NQueens2 {
	public int totalNQueens(int n) {
		if (n <= 0) {
			return 0;
		}
		int[] cols = new int[n];
		int[] result = new int[1];
		helper(n, cols, 0, result);
		return result[0];
	}

	private void helper(int n, int[] cols, int row, int[] result) {
		if (row == n) {
			result[0]++;
		}
		for (int i = 0; i < n; i++) {
			if (isValidPos(row, i, cols)) {
				cols[row] = i;
				helper(n, cols, row + 1, result);
			}
		}
	}

	private boolean isValidPos(int row, int col, int[] cols) {
		for (int i = 0; i < row; i++) {
			if (cols[i] == col) {
				return false;
			}
			int rowDistance = row - i;
			int colDistance = Math.abs(col - cols[i]);
			if (rowDistance == colDistance) {
				return false;
			}
		}
		return true;
	}
}