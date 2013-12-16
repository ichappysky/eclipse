package matrix;

import java.util.ArrayList;

public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}

		return helper(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
	}

	private ArrayList<Integer> helper(int[][] matrix, int startRow, int endRow,
			int startCol, int endCol) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (startRow > endRow || startCol > endCol) {
			return result;
		}
		// top row
		for (int j = startCol; j <= endCol; j++) {
			result.add(matrix[startRow][j]);
		}
		if (startRow == endRow) {
			return result;
		}
		// rightmost col
		for (int i = startRow + 1; i <= endRow; i++) {
			result.add(matrix[i][endCol]);
		}
		if (startCol == endCol) {
			return result;
		}
		// bottom row
		for (int j = endCol - 1; j >= startCol; j--) {
			result.add(matrix[endRow][j]);
		}
		// leftmost col
		for (int i = endRow - 1; i > startRow; i--) {
			result.add(matrix[i][startCol]);
		}
		result.addAll(helper(matrix, startRow + 1, endRow - 1, startCol + 1,
				endCol - 1));
		return result;
	}
}
