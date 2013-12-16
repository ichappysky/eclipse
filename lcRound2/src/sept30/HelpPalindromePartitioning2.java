package sept30;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return 1 since the palindrome partitioning
 * ["aa","b"] could be produced using 1 cut.
 * 
 * @author yongz
 * 
 */
public class HelpPalindromePartitioning2 {
	public int minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		boolean[][] isPa = new boolean[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			isPa[i][i] = true;
		}
		for (int i = s.length() - 2; i >= 0; i--) {
			isPa[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
			for (int j = i + 2; j < s.length(); j++) {
				isPa[i][j] = (s.charAt(i) == s.charAt(j) && isPa[i + 1][j - 1]);
			}
		}

		int[] cuts = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			cuts[i] = -1;
		}
		return helper(s, 0, isPa, cuts);
	}

	private int helper(String s, int start, boolean[][] isPa, int[] cuts) {
		if (start == s.length()) {
			return -1;
		}

		if (cuts[start] != -1) {
			return cuts[start];
		}
		int result = Integer.MAX_VALUE;
		for (int i = start; i < s.length(); i++) {
			if (isPa[start][i]) {
				result = Math.min(result, helper(s, i + 1, isPa, cuts) + 1);
			}
		}
		cuts[start] = result;
		return result;
	}

	public static void main(String[] x) {
		String s = "efe";
		HelpPalindromePartitioning2 t = new HelpPalindromePartitioning2();
		System.out.print(t.minCut(s));
	}
}
