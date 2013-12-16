package string;
public class LongestSubPalindrome {
	public String longestPalindrome(String ss) {
		String s = preProcess(ss);
		int center = 0;
		int right = 0;
		int p[] = new int[s.length()];

		for (int i = 1; i < s.length()-1; i++) {
			int i_left = 2 * center - i;
			p[i] = right > i ? Math.min(right - i, p[i_left]) : 0;
			while ( s.charAt(i - 1- p[i]) == s.charAt(i + p[i] +1)) {
				p[i]++;
			}

			if (p[i] + i > right) {
				center = i;
				right = p[i] + i;
			}
		}

		int max = 0;
		int maxIndex = 0 ;
		for (int i = 0; i < p.length; i++) {
			if (p[i] > max) {
				max = p[i];
				maxIndex =i;
			}
		}

		String r = s.substring(maxIndex - p[maxIndex], maxIndex + p[maxIndex]);
		return r.replace("#", "");
	}

	private String preProcess(String s) {
		String r = "^#";
		for (int i = 0; i < s.length(); i++) {
			r += s.charAt(i) + "#";
		}
		r += "$";
		return r;
	}
	
	public static void main (String[]a) {
		LongestSubPalindrome t = new LongestSubPalindrome();
		System.out.println(t.longestPalindrome("a"));
	}
}
