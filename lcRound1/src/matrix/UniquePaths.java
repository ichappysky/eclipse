package matrix;

import java.util.Arrays;

public class UniquePaths {
	// Method 1 -- DP 
	// Method 2 -- choose m out of (m+n) ==> (m+n-2)!/((m-1)! * (n-1)!)
	public int uniquePaths(int m, int n) {
		if (m < 0 || n < 0) {
			return 0;
		}
		if (m == 0 || n == 0) {
			return 1;
		}
		// DP: f (i, j) = f(i-1, j) + f(i, j-1);
		int[] f = new int[n + 1];
		Arrays.fill(f, 0);
		f[1] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				f[j + 1] = f[j] + f[j + 1];
			}
		}

		return f[n];
	}

}