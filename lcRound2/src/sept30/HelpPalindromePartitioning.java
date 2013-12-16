package sept30;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 * 
 * @author yongz
 * 
 */
public class HelpPalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
		if (s == null || s.length() == 0) {
			return new ArrayList<ArrayList<String>>();
		}

		boolean[][] isPa = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			isPa[i][i] = true;
		}

		for (int i = s.length() - 2; i >= 0; i--) {
			isPa[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
			for (int j = i + 2; j < s.length(); j++)
				isPa[i][j] = (s.charAt(i) == s.charAt(j)) && isPa[i + 1][j - 1];
		}

		return helper(s, 0, isPa);
	}

	private ArrayList<ArrayList<String>> helper(String s, int index,
			boolean[][] isPa) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (index >= s.length()) {
			result.add(new ArrayList<String>());
			return result;
		}

		for (int i = index; i < s.length(); i++) {
			String firstSeg = s.substring(index, i + 1);
			if (isPa[index][i]) {
				for (ArrayList<String> oneList : helper(s, i + 1, isPa)) {
					ArrayList<String> newList = new ArrayList<String>(oneList);
					newList.add(0, firstSeg);
					result.add(newList);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		HelpPalindromePartitioning tester = new HelpPalindromePartitioning();

		System.out.println(tester.partition("abbc"));
	}
}
