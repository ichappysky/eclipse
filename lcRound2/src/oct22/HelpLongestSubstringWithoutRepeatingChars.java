package oct22;

public class HelpLongestSubstringWithoutRepeatingChars {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		boolean[] found = new boolean[256];
		int start = 0;
		int end = 0;
		int max = 0;
		for (; end < s.length(); end++) {
			char cur = s.charAt(end);
			if (!found[cur]) {
				found[cur] = true;
			} else {
				max = Math.max(max, end - start);
				while (s.charAt(start) != cur) {
					found[s.charAt(start)] = false;
					start++;
				}
				start++;
			}
		}

		max = Math.max(max, end - start);
		return max;
	}
}