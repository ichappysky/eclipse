package string;
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if (s == null && p == null) {
			return true;
		} else if (s == null || p == null) {
			return false;
		} else {
			return helper(s, p, 0, 0);
		}

	}

	private boolean helper(String s, String p, int i, int j) {
		// no more char in pattern
		if (j == p.length()) {
			return s.length() == i;
		}

		// next char in pattern is not *
		if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
			if (i == s.length()) {
				return false;
			}
			return (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))
					&& helper(s, p, i + 1, j + 1);
		}
		// next char in pattern is  *
		while (i < s.length()
				&& (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {

			if (helper(s, p, i++, j + 2)) {
				return true;
			}
		}
		// none matched. take * as none and move on
		return helper(s, p, i, j + 2);

	}
	
	public static void main (String[] a) {
		RegularExpressionMatching t = new RegularExpressionMatching();
		t.isMatch("aab", "c*a*b");
	}
}
