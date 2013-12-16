package oct10;

/**
 * Given an integer n, generate a square matrix filled 
 * with elements from 1 to n2 in spiral order.

For example,
Given n = 3,
You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

 * @author yongz
 *
 */
public class SpiralMatrix2 {
	public int[][] generateMatrix(int n) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (n < 1) {
			throw new IllegalArgumentException();
		}

		int[][] result = new int[n][n];

		helper(result, 0, n - 1, 0, n - 1, 1);

		return result;
	}

	private void helper(int[][] matrix, int startRow, int endRow, int startCol,
			int endCol, int num) {
		if (startRow > endRow || startCol > endCol) {
			return;
		}
		for (int j = startCol; j <= endCol; j++) {
			matrix[startRow][j] = num++;
		}
		for (int i = startRow + 1; i <= endRow; i++) {
			matrix[i][endCol] = num++;
		}
		for (int j = endCol - 1; j >= startCol; j--) {
			matrix[endRow][j] = num++;
		}
		for (int i = endRow - 1; i > startRow; i--) {
			matrix[i][startCol] = num++;
		}
		helper(matrix, startRow + 1, endRow - 1, startCol + 1, endCol - 1, num);
	}
}
