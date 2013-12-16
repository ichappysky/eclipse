package oct12;

import java.util.Arrays;

public class RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0
				|| matrix.length != matrix[0].length) {
			return;
		}
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int tmp = matrix[i][j];

				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = tmp;
			}
		}

	}

	public void rotate1(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int n = matrix.length;
		for (int i = 0; i < n / 2; ++i) {
			for (int j = i; j < n - 1 - i; ++j) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = t;
			}
		}
	}

	public static void main(String[] a) {
		RotateImage t = new RotateImage();
		int[][] m = new int[][] { { 1, 2 }, { 3, 4 } };
		t.rotate(m);

		System.out.print(Arrays.toString(m));

	}
}