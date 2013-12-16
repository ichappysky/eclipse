package oct06;

public class HelpMaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int n = matrix[0].length;
		int[] height = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];
		for (int i = 0; i < n; i++) {
			right[i] = n;
		}
		int result = 0;
		for (int i = 0; i < matrix.length; i++) {
			int leftMost = 0;
			int rightMost = n;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
					left[j] = Math.max(left[j], leftMost);
				} else {
					leftMost = j + 1;
					left[j] = 0; // reset to 0 so doesn't impact next row.
					height[j] = 0;
				}
			}
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(rightMost, right[j]);
					result = Math.max(result, height[j] * (right[j] - left[j]));
				} else {
					rightMost = j;
					right[j] = n;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		char[][] m = { { '1' } };

		HelpMaximalRectangle t = new HelpMaximalRectangle();
		System.out.print(t.maximalRectangle(m));
	}
}