package oct03;

import java.util.HashMap;
import java.util.Map;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 * 
 * @author yongz
 * 
 */
public class HelpInterleavingStrings {
	// Limit Time Exceeded
	public boolean isInterleaveRecursive(String s1, String s2, String s3) {
		Map<String, Boolean> keyToResult = new HashMap<String, Boolean>();
		return helper(s1, 0, s2, 0, s3, 0, keyToResult);

	}

	private boolean helper(String s1, int start1, String s2, int start2,
			String s3, int start3, Map<String, Boolean> keyToResult) {
		if (start1 >= s1.length() || start2 >= s2.length()
				|| start3 >= s3.length()) {
			return false;
		}
		String key = start1 + ":" + start2 + ":" + start3;
		if (keyToResult.containsKey(key)) {
			return keyToResult.get(key);
		}
		boolean result = ((s1.charAt(start1) == s3.charAt(start3)) && helper(
				s1, start1 + 1, s2, start2, s3, start3 + 1, keyToResult))
				|| ((s2.charAt(start2) == s3.charAt(start3)) && helper(s1,
						start1, s2, start2 + 1, s3, start3 + 1, keyToResult));
		keyToResult.put(key, result);
		return result;
	}

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
			result[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1))
					&& result[i - 1][0];
		}
		for (int i = 1; i <= s2.length(); i++) {
			result[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1))
					&& result[0][i - 1];
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				result[i][j] = ((s1.charAt(i - 1) == s3.charAt(i + j - 1)) && result[i - 1][j])
						|| ((s2.charAt(j - 1) == s3.charAt(i + j - 1)) && result[i][j - 1]);
			}
		}
		return result[s1.length()][s2.length()];
	}

	public static void main(String[] x) {
		HelpInterleavingStrings t = new HelpInterleavingStrings();
		t.isInterleave("a", "b", "ab");
	}
}
