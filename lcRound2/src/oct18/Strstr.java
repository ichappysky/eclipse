package oct18;

public class Strstr {
	public String strStr(String a, String b) {
		if (a == null || b == null) {
			return null;
		}
		if (a.length() == 0) {
			if (b.length() == 0) {
				return "";
			}
			return null;
		}
		if (b.length() == 0) {
			return a;
		}

		for (int i = 0; i < a.length() - b.length() + 1; i++) {
			int j = 0;
			for (; j < b.length(); j++) {
				if (a.charAt(i + j) != b.charAt(j)) {
					break;
				}
			}
			if (j == b.length()) {
				return a.substring(i);
			}
		}
		return null;
	}

}
