package string;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		int n = s1.length();
		boolean[][][] dp = new boolean[n][n][n + 1];

		// 3 dimensional dynamic programming: f(i, j, n) = || ((f(i, j, m) &&
		// f(i + m, j + m, n - m)) || f(i, j + n - m, m) && f(i + m, j, n - m))
		// for 1 < m < n where f(i, j, n) is true iff substring starts at s1[i]
		// and substring starts at s2[j] both with length n are scrambled
		for (int i = n - 1; i >= 0; i--)
			for (int j = n - 1; j >= 0; j--)
				for (int k = 1; k <= n - Math.max(i, j); k++) {
					if (s1.substring(i, i + k).equals(s2.substring(j, j + k))) {
						dp[i][j][k] = true;
					} else {
						for (int r = 1; r < k; r++) {
							if (dp[i][j][r] && dp[i + r][j + r][k - r]
									|| dp[i][j + k - r][r]
									&& dp[i + r][j][k - r]) {
								dp[i][j][k] = true;
								break;
							}
						}
					}
				}

		return dp[0][0][n];
	}

	public static void main(String[] args) {
		ScrambleString t = new ScrambleString();

		System.out.print(t.isScramble("abcd", "badc"));
	}
}