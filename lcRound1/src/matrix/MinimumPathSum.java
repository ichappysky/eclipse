package matrix;

import java.util.Arrays;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		// f[i][j] = min (f(i-1, j), f(i, j-1)) +grid[i][j]
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;

		int[] f = new int[n + 1];
		// dummy one
		Arrays.fill(f, Integer.MAX_VALUE);
		f[1] = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				f[j + 1] = Math.min(f[j], f[j + 1]) + grid[i][j];
			}
		}
		return f[n];
	}
}