package oct21;

import java.util.ArrayList;

public class MistakeGenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		if (n <= 0) {
			return result;
		}
		char[] path = new char[2 * n];
		helper(n, n, 0, path, result);
		return result;
	}

	// mistake: didn't have index parameter. instead - used left+right-1 to calculate index
	// so the output was in the reversed order
	private void helper(int leftNeeded, int rightNeeded, int index, char[] path,
			ArrayList<String> result) {
		if (leftNeeded == 0 && rightNeeded == 0) {
			result.add(String.valueOf(path));
			return;
		}
		if (leftNeeded > 0) {
			path[index] = '(';
			helper(leftNeeded - 1, rightNeeded, index + 1, path, result);
		}
		if (rightNeeded > leftNeeded) {
			path[index] = ')';
			helper(leftNeeded, rightNeeded - 1, index + 1, path, result);
		}

	}

}
