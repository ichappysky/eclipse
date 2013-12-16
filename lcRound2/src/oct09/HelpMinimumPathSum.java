package oct09;

import java.util.Arrays;

public class HelpMinimumPathSum {
	public int minPathSum(int[][] grid) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int n = grid[0].length;
		int[] sum = new int[n + 1];
		// MISSED the tricky point of these two line
		Arrays.fill(sum, Integer.MAX_VALUE);
		sum[0] = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < n; j++) {
				sum[j + 1] = Math.min(sum[j + 1], sum[j]) + grid[i][j];
			}
		}
		return sum[n];

	}

	public static void main(String[] x) {
		HelpMinimumPathSum t = new HelpMinimumPathSum();
		t.minPathSum(new int[][] { { 1, 2 }, { 1, 1 } });
	}
}
