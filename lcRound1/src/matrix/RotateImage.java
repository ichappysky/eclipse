package matrix;

public class RotateImage {
	public void rotate(int[][] matrix) {
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
		t.rotate(new int[][] { { 1, 2, 3, 4 }, { 21, 22, 23, 24 },
				{ 31, 32, 33, 34 }, { 41, 42, 43, 44 } });
	}
}