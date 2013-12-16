package chapter01ArraysAndStrings;

public class SetZerosInMatrix {
	public static void setZeros(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		boolean firstRowHasZeros = false;
		boolean firstColHasZeros = false;
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				firstRowHasZeros = true;
				break;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				firstColHasZeros = true;
				break;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		if (firstColHasZeros) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
		if (firstRowHasZeros) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}
	}

	// [[0,0,0,5],[4,3,1,4],[0,1,1,4],[1,2,1,3],[0,0,1,1]]
	// [[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
	// [[0,0,0,0],[0,0,0,4],[0,0,0,0],[0,0,0,3],[0,0,0,0]]

	public static void main(String[] args) {
		
		int[][] matrix1 = new int[][]{{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};

		setZeros(matrix1);

		System.out.println();

	}
}
