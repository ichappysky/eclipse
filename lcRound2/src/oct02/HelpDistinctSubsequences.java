package oct02;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * @author yongz
 * 
 */
public class HelpDistinctSubsequences {
	public int numDistinct(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0) {
			return 0;
		}
		int[] ways = new int[t.length() + 1];
		//
		ways[0] = 1;
		for (int i = 0; i < s.length(); i++) {
			for (int j = t.length() - 1; j >= 0; j--) {
				if (s.charAt(i) == t.charAt(j)) {
					ways[j + 1] += ways[j];
				}
			}
		}
		return ways[t.length()];
	}

	public static void main(String[] args) {
		HelpDistinctSubsequences t = new HelpDistinctSubsequences();

		System.out.println(t.numDistinct("rabbbitabc", "rabbit"));
	}
}
