package string;
import java.util.ArrayList;

public class AllPalindromePartitions {
	public ArrayList<ArrayList<String>> partition(String s) {
		if (s == null || s.length() == 0)
			return new ArrayList<ArrayList<String>>();
		boolean[][] isPa = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			isPa[i][i] = true;
		}
		for (int i = s.length() - 2; i >= 0; i--) {
			isPa[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
			for (int j = i + 2; j < s.length(); j++)
				isPa[i][j] = (s.charAt(i) == s.charAt(j)) && isPa[i + 1][j - 1];
		}
		System.out.print(isPa);
		return partitionHelper(s, 0, isPa);
	}

	private ArrayList<ArrayList<String>> partitionHelper(String s, int start,
			boolean[][] isPalindrome) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (start == s.length()) {
			result.add(new ArrayList<String>());
			return result;
		}
		for (int i = start; i < s.length(); i++) {
			if (isPalindrome[start][i]) {
				for (ArrayList<String> subPa : partitionHelper(s, i + 1,
						isPalindrome)) {
					subPa.add(0, s.substring(start, i + 1));
					result.add(subPa);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		AllPalindromePartitions tester = new AllPalindromePartitions();

		System.out.println(tester.partition("abbab"));
	}
}
