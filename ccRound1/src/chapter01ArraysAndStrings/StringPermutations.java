package chapter01ArraysAndStrings;

public class StringPermutations {
	public static boolean permutation(String s, String t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		int[] counts = new int[256];
		for (int i = 0; i < s.length(); i++) {
			counts[s.charAt(i)]++;
		}
		for (int i = 0; i < t.length(); i++) {
			counts[t.charAt(i)]--;
			if (counts[t.charAt(i)] < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[][] pairs = { { "apple", "papel" }, { "carrot", "tarroc" },
				{ "hello", "llloh" } };
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = permutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}
	}

}
