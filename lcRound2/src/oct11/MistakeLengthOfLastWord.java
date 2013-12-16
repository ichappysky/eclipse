package oct11;

public class MistakeLengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int result = 0, curLen = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				if (curLen != 0) {
					result = curLen;
				}
				curLen = 0;
			} else {
				curLen++;
			}
		}
		return curLen == 0 ? result : curLen;
	}

	public static void main(String[] x) {
		MistakeLengthOfLastWord t = new MistakeLengthOfLastWord();
		t.lengthOfLastWord("a  ");
	}
}