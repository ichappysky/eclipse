package oct23;

public class HelpLongestPalindrome {
	public String longestPalindrome(String ss) {
		if (ss == null || ss.length() == 0) {
			return ss;
		}
		String s = processString(ss);
		int center = 0;
		int right = 0;
		int[] len = new int[s.length()];
		for (int i = 1; i < s.length() - 1; i++) {
			int pal = 2 * center - i;
			len[i] = right > i ? Math.min(right - i, len[pal]) : 0;
			while (s.charAt(i - 1 - len[i]) == s.charAt(i + 1 + len[i])) {
				len[i]++;
			}
			if (len[i] + i > right) {
				center = i;
				right = len[i] + i;
			}
		}
		int maxLen = 0;
		int maxIndex = 0;
		for (int i = 1; i < s.length() - 1; i++) {
			if (len[i] > maxLen) {
				maxLen = len[i];
				maxIndex = i;
			}
		}

		String result = s.substring(maxIndex - maxLen, maxIndex + maxLen + 1);
		return result.replace("#", "");

	}

	private String processString(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append("^#");
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i)).append("#");
		}
		sb.append("$");
		return sb.toString();
	}

	public static void main(String[] a) {
		HelpLongestPalindrome t = new HelpLongestPalindrome();
		System.out.println(t.longestPalindrome("a"));
	}
}
