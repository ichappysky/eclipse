package string;

public class WildcardMatching {

	public boolean isMatch(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();

		int i = 0;
		int j = 0;
		// star是上一个*出现的位置
		int star = -1;
		// s_save+1是出现不匹配时，s应该回到的位置。
		int lastMatchedPosInS = 0;

		while (i < sLen) {
			// one * and multiple *, same effect
			while (j < pLen && p.charAt(j) == '*') {
				star = j++; 
				lastMatchedPosInS = i;
			}

			// 不匹配
			if (j == pLen || (p.charAt(j) != s.charAt(i) && p.charAt(j) != '?')) {
				// 没有*来做灵活匹配
				if (star < 0)
					return false;
				else {
					j = star + 1;
					// * match 1 more character
					// 一直不能匹配的时候，s_save也一直增加，就跟简单字符串匹配差不多
					i = ++lastMatchedPosInS;
				}
			} else {
				i++;
				j++;
			}
		}

		// pattern结尾的*可以消耗掉
		while (j < pLen && p.charAt(j) == '*') {
			j++;
		}
		// 看是否已经到p的末尾
		return j == pLen;
	}

	public static void main(String[] a) {
		WildcardMatching t = new WildcardMatching();
		System.out.println(t.isMatchRecursive("aa", "*"));
	}

	public boolean isMatchRecursive(String s, String p) {
		if (s == null && p == null) {
			return true;
		}
		if (s == null || p == null) {
			return false;
		}
		return helper(s, p, 0, 0);
	}

	private boolean helper(String s, String p, int i, int j) {
		if (j >= p.length()) {
			return i >= s.length();
		}

		if (p.charAt(j) != '*') {
			if (i == s.length()) {
				return false;
			}
			return (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
					&& helper(s, p, i + 1, j + 1);
		}
		while (j < p.length()) {
			if (p.charAt(j) == '*') {
				j++;
			} else {
				break;
			}
		}

		while (i <= s.length()) {
			if (helper(s, p, i++, j + 1)) {
				return true;
			}
		}
		return false;
	}
}