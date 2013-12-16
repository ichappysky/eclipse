package chapter01ArraysAndStrings;

public class IsRotation {
	public static boolean isRotation(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		}
		if (s1 == null || s2 == null) {
			return false;
		}
		String tmp = s1 + s1;
		if (tmp.indexOf(s2) >= 0) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		String[][] pairs = { { "apple", "pleap" },
				{ "waterbottle", "erbottlewat" }, { "camera", "macera" } };
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean is_rotation = isRotation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + is_rotation);
		}
	}
}
