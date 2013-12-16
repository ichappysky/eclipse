package matrix;

import java.util.Arrays;

public class UniquePaths2 {
	public int uniquePathsWithObstacles(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;
		int[] f = new int[n + 1];
		Arrays.fill(f, 0);
		if (grid[0][0] == 0) {
			f[1] = 1;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					f[j + 1] = 0;

				} else {
					f[j + 1] = f[j] + f[j + 1];
				}
			}
		}

		return f[n];
	}
}