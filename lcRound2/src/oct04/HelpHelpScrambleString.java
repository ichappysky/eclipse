package oct04;

/**
 * Given a string s1, we may represent it as a binary tree 
 * by partitioning it to two non-empty substrings recursively.
 *  Below is one possible representation of s1 = "great": 
    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap
 its two children. For example, if we choose the node "gr" and 
 swap its two children, it produces a scrambled string "rgeat". 
    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great". Similarly,
 if we continue to swap the children of nodes "eat" and "at", 
 it produces a scrambled string "rgtae". 
    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".
 Given two strings s1 and s2 of the same length, 
 determine if s2 is a scrambled string of s1. 

 * @author yongz
 *
 */
public class HelpHelpScrambleString {
	public boolean isScramble(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		}
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		int n = s1.length();
		// result[i][j][k] s1 starting from i, s2 from j, two substrings with k
		// length are scrambled.
		boolean[][][] result = new boolean[n][n][n + 1];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				for (int k = 1; k <= n - Math.max(i, j); k++) {
					if (s1.substring(i, i + k).equals(s2.substring(j, j + k))) {
						result[i][j][k] = true;
					} else {
						for (int r = 1; r < k; r++) {
							if ((result[i][j + k - r][r] && result[i + r][j][k- r])
									|| (result[i][j][r] && result[i + r][j + r][k- r])) {
								result[i][j][k] = true;
								break;
							}
						}
					}
				}
			}
		}
		return result[0][0][n];
	}
}