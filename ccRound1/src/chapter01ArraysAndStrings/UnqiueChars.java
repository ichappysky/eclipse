package chapter01ArraysAndStrings;

public class UnqiueChars {

	public static boolean isUniqueChars(String str) {
		boolean[] existed = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if (existed[cur]) {
				return false;
			}
			existed[cur] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		String[] words = { "abcde", "hello", "apple", "kite", "padle" };
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}
}
