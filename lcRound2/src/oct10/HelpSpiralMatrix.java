package oct10;

import java.util.ArrayList;

public class HelpSpiralMatrix {
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
		for (int j = startCol; j <= endCol; j++) {
			result.add(matrix[startRow][j]);
		}
		for (int i = startRow + 1; i <= endRow; i++) {
			result.add(matrix[i][endCol]);
		}
		if (startCol == endCol) {
			return result;
		}
		for (int j = endCol - 1; j >= startCol; j--) {
			result.add(matrix[endRow][j]);
		}
		for (int i = endRow - 1; i > startRow; i--) {
			result.add(matrix[i][startCol]);
		}
		result.addAll(helper(matrix, startRow + 1, endRow - 1, startCol + 1,
				endCol - 1));
		return result;

	}
	
	public static void main(String[]x ) {
		HelpSpiralMatrix t = new HelpSpiralMatrix();
		t.spiralOrder(new int[][]{{2,3}});
	}
}