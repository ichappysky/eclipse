package oct07;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC"
 * 
 * Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * @author yongz
 * 
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0) {
			throw new IllegalArgumentException("wrong input");
		}
		int foundCount = 0;
		int[] found = new int[256];
		int[] need = new int[256];
		for (int i = 0; i < t.length(); i++) {
			need[t.charAt(i)]++;
		}
		String result = s + t;
		for (int start = 0, end = 0; end < s.length(); end++) {
			char cur = s.charAt(end);
			found[cur]++;
			if (found[cur] <= need[cur]) {
				foundCount++;
			}
			if (foundCount == t.length()) {
				char startChar = s.charAt(start);
				while (need[startChar] == 0
						|| found[startChar] > need[startChar]) {
					if (found[startChar] > need[startChar]) {
						found[startChar]--;
					}
					start++;
					startChar = s.charAt(start);
				}
				String curWindow = s.substring(start, end + 1);
				if (curWindow.length() < result.length()) {
					result = curWindow;

				}
			}
		}

		return result.length() > s.length() ? "" : result;

	}

	public static void main(String[] x) {
		MinimumWindowSubstring t = new MinimumWindowSubstring();
		System.out.print(t.minWindow("ADOBECODEBANC", "ABC"));
	}

}