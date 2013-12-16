package matrix;


public class SpiralMatrix2 {
	public int[][] generateMatrix(int n) {
		if (n < 0) {
			return null;
		}
		int[][] matrix = new int[n][n];

		helper(matrix, 0, n - 1, 0, n - 1, 1);
		return matrix;
	}

	private void helper(int[][] matrix, int startRow, int endRow, int startCol,
			int endCol, int startNum) {
		if (startRow > endRow || startCol > endCol) {
			return;
		}
		// top row
		for (int j = startCol; j <= endCol; j++) {
			matrix[startRow][j] = startNum++;
		}
		if (startRow == endRow) {
			return;
		}
		// rightmost col
		for (int i = startRow + 1; i <= endRow; i++) {
			matrix[i][endCol] = startNum++;
		}
		if (startCol == endCol) {
			return;
		}
		// bottom row
		for (int j = endCol - 1; j >= startCol; j--) {
			matrix[endRow][j] = startNum++;
		}
		// leftmost col
		for (int i = endRow - 1; i > startRow; i--) {
			matrix[i][startCol] = startNum++;
		}
		helper(matrix, startRow + 1, endRow - 1, startCol + 1, endCol - 1,
				startNum);

	}
}
