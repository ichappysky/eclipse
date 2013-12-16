package string;

public class LongestSubstringWithoutRepeatingChars {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		boolean[] foundChars = new boolean[256];
		int max = Integer.MIN_VALUE;
		int start = 0, end = 0;
		for (; end < s.length(); end++) {
			char cur = s.charAt(end);
			if (!foundChars[cur]) {
				foundChars[cur] = true;
			} else {
				int curLength = end - start ;
				max = Math.max(max, curLength);
				while (s.charAt(start) != cur) {
					foundChars[s.charAt(start)] = false;
					start++;
				}
				start++;
			}
		}
		max = Math.max(max, end - start);

		return max;
	}
}