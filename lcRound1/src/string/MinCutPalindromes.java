package string;
public class MinCutPalindromes {
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
			for (int j = i + 2; j < s.length(); j++)
				isPa[i][j] = (s.charAt(i) == s.charAt(j)) && isPa[i + 1][j - 1];
		}

		int[] cuts = new int[s.length()];
		for (int i = 0; i < cuts.length; i++) {
			cuts[i] = -1;
		}
		return partitionHelper(s, 0, isPa, cuts);
	}

	private int partitionHelper(String s, int start, boolean[][] isPalindrome,
			int[] cuts) {
		if (start == s.length()) {
			return -1;
		}

		if (cuts[start] != -1) {
			return cuts[start];
		}

		int min = Integer.MAX_VALUE;
		for (int i = start; i < s.length(); i++) {
			if (!isPalindrome[start][i]) {
				continue;
			}
			int minCutOfRest = partitionHelper(s, i + 1, isPalindrome, cuts);
			if (min > minCutOfRest + 1) {
				min = minCutOfRest + 1;
			}
		}
		cuts[start] = min;
		return min;
	}
	
	public static void main(String[]x) {
		String s = "efe";
		MinCutPalindromes t = new MinCutPalindromes();
		System.out.print(t.minCut(s));
	}
}
