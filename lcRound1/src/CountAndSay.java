public class CountAndSay {
	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		String prev = countAndSay(n - 1);
		char[] prevArray = prev.toCharArray();
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 0; i < prevArray.length; i++) {
			if (i + 1 < prevArray.length && prevArray[i] == prevArray[i + 1]) {
				count++;
				continue;
			}
			sb.append(count).append(prevArray[i]);
			count = 1;
		}
		return sb.toString();
	}
}