package string;

public class WildcardMatching {

	public boolean isMatch(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();

		int i = 0;
		int j = 0;
		// star����һ��*���ֵ�λ��
		int star = -1;
		// s_save+1�ǳ��ֲ�ƥ��ʱ��sӦ�ûص���λ�á�
		int lastMatchedPosInS = 0;

		while (i < sLen) {
			// one * and multiple *, same effect
			while (j < pLen && p.charAt(j) == '*') {
				star = j++; 
				lastMatchedPosInS = i;
			}

			// ��ƥ��
			if (j == pLen || (p.charAt(j) != s.charAt(i) && p.charAt(j) != '?')) {
				// û��*�������ƥ��
				if (star < 0)
					return false;
				else {
					j = star + 1;
					// * match 1 more character
					// һֱ����ƥ���ʱ��s_saveҲһֱ���ӣ��͸����ַ���ƥ����
					i = ++lastMatchedPosInS;
				}
			} else {
				i++;
				j++;
			}
		}

		// pattern��β��*�������ĵ�
		while (j < pLen && p.charAt(j) == '*') {
			j++;
		}
		// ���Ƿ��Ѿ���p��ĩβ
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