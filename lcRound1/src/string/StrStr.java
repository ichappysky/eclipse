package string;

public class StrStr {
	public String strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return null;
		}
		if (haystack.length() == 0) {
			if (needle.length() == 0) {
				return "";
			}
			return null;
		}
		if (needle.length() == 0) {
			return haystack;
		}

		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			int j = 0;
			for (; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
			if (j == needle.length()) {
				return haystack.substring(i);
			}
		}
		return null;
	}
}
