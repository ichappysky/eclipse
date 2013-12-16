package string;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		if (S == null || S.length() == 0 || T == null) {
			return null;
		}
		if (T.length() == 0) {
			return "";
		}

		int minSize = Integer.MAX_VALUE;
		String result = "";

		int[] needed = new int[256];
		for (int i = 0; i < T.length(); i++) {
			needed[T.charAt(i)]++;
		}
		int[] hasFound = new int[256];

		int foundCount = 0;
		for (int start = 0, end = 0; end < S.length(); end++) {
			char curChar = S.charAt(end);
			hasFound[curChar]++;
			if (hasFound[curChar] <= needed[curChar]) {
				foundCount++;
			}
			if (foundCount == T.length()) {
				while (needed[S.charAt(start)] == 0
						|| hasFound[S.charAt(start)] > needed[S.charAt(start)]) {
					if (hasFound[S.charAt(start)] > needed[S.charAt(start)]) {
						hasFound[S.charAt(start)]--;
					}

					start++;

				}
				int curWindowSize = end - start + 1;
				if (curWindowSize < minSize) {
					minSize = curWindowSize;
					result = S.substring(start, end + 1);
				}

			}
		}
		return result;
	}

	public static void main(String[] a) {
		MinimumWindowSubstring t = new MinimumWindowSubstring();
		System.out.print(t.minWindow("ab", "b"));
	}
}
