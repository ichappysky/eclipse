package oct09;

public class UniquePath {
	public int uniquePaths(int m, int n) {
		if (m < 1 || n < 1) {
			throw new IllegalArgumentException();
		}
		int[] path = new int[n + 1];
		path[1] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				path[j + 1] += path[j];
			}
		}
		return path[n];
	}

}
