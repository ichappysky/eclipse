package oct23;

public class HelpRegularExpressionMatching {
	public boolean isMatch(String s, String p) {

		if (s == null && p == null) {
			return true;
		}
		if (s == null || p == null) {
			return false;
		}
		return helper(s, p, 0, 0);
	}

	private boolean helper(String s, String p, int i, int j) {
		if (j == p.length()) {
			return i == s.length();
		}
		
			if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
				if (i == s.length()) {
					return false;
				}
				return (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
						&& helper(s, p, i + 1, j + 1);
			}
	
			while (i < s.length()
					&& (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
				if (helper(s, p, i , j + 2)) {
					return true;
				}
				i++;
			}
	
			return helper(s, p, i, j + 2);
	}

}
