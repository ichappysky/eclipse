package matrix;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int cur = s.length() - 1;
		boolean trailingSpaces = true;
		int len = 0;
		while (cur >= 0) {
			char curChar = s.charAt(cur);
			if (curChar == ' ') {
				if (trailingSpaces) {
					cur--;
				} else {
					break;
				}
			} else {
				len++;
				cur--;
				trailingSpaces = false;
			}
		}

		return len;
	}
}
