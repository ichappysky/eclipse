package oct09;

public class UniquePath2 {
	public int uniquePathsWithObstacles(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			throw new IllegalArgumentException();
		}
		int m = grid.length;
		int n = grid[0].length;
		int[] path = new int[n + 1];
		path[1] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					path[j + 1] = 0;
				} else {
					path[j + 1] += path[j];
				}
			}
		}
		return path[n];
	}
}