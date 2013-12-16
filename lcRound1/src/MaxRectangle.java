public class MaxRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int n = matrix[0].length;
		int[] H = new int[n];
		int[] L = new int[n];
		int[] R = new int[n]; // all Rs are far most
		for (int i = 0; i < n; i++) {
			R[i] = n;
		}
		int ret = 0;
		for (int i = 0; i < matrix.length; ++i) {
			int left = 0, right = n;
			// calculate L(i, j) from left to right
			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] == '1') {
					++H[j];
					L[j] = Math.max(L[j], left);
				} else {
					
					left = j + 1; 
					H[j] = 0;
					L[j] = 0;
					R[j] = n;
				}
			}
			// calculate R(i, j) from right to right
			for (int j = n - 1; j >= 0; --j) {
				if (matrix[i][j] == '1') {
					R[j] = Math.min(R[j], right);
					ret = Math.max(ret, H[j] * (R[j] - L[j]));
				} else {
					right = j;
				}
			}
		}

		return ret;

	}

	public static void main(String[] args) {
		char[][] m = { { '0', '1', '0', '1', '0' }, { '0', '1', '0', '0', '0' } };

		MaxRectangle t = new MaxRectangle();
		System.out.print(t.maximalRectangle(m));
	}
}