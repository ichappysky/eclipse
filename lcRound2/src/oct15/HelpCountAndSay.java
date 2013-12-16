package oct15;

public class HelpCountAndSay {
	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}

		String subresult = countAndSay(n - 1);
		char[] chars = subresult.toCharArray();
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
				sb.append(count).append(chars[i]);
				count = 1;
			} else {
				count++;
			}
		}

		return sb.toString();
	}
}
