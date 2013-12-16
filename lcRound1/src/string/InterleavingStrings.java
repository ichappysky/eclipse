package string;
public class InterleavingStrings {
	public boolean isInterleave(String s1, String s2, String s3) {
		// validate nullity
		if (s1 == null && s2 == null && s3 == null) {
			return true;
		}
		if ((s1 == null && s2 == null) || (s2 == null && s3 == null)
				|| (s1 == null && s3 == null)) {
			return false;
		}
		if (s1 == null) {
			return s2.equals(s3);
		}
		if (s2 == null) {
			return s1.equals(s3);
		}
		if (s3 == null) {
			return s1.equals(s2);
		}
		// validate length
		if (s3.length() != (s1.length() + s2.length())) {
			return false;
		}

		boolean[][] result = new boolean[s1.length() + 1][s2.length() + 1];
		result[0][0] = true;
		for (int i = 1; i <= s1.length(); i++) {
			result[i][0] = s3.charAt(i - 1) == s1.charAt(i - 1)&& result[i-1][0];

		}
		for (int j = 1; j <= s2.length(); j++) {
			result[0][j] = (s3.charAt(j - 1) == s2.charAt(j - 1)) && result[0][j-1];
		}
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				result[i][j] = ((s3.charAt(i + j - 1) == s1.charAt(i - 1)) && result[i - 1][j])
						|| ((s3.charAt(i + j - 1) == s2.charAt(j - 1)) && result[i][j - 1]);
			}
		}

		return result[s1.length()][s2.length()];
	}
	
	public static void main(String[] args) {
		InterleavingStrings t = new InterleavingStrings();
		System.out.print(t.isInterleave("a", "b", "ab"));
	}
}