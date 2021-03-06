package oct22;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		for (int i = 0; i < strs[0].length(); i++) {
			char cur = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() <= i || strs[j].charAt(i) != cur) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];

	}
}
