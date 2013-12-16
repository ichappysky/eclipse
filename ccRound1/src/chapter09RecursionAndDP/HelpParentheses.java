package chapter09RecursionAndDP;

import java.util.ArrayList;
import java.util.List;

public class HelpParentheses {
	public static ArrayList<String> generateParens(int n) {
		ArrayList<String> result = new ArrayList<String>();
		if (n < 1) {
			return result;
		}
		helper(new char[2 * n], n, n, 0, result);
		return result;
	}

	private static void helper(char[] chars, int leftNeeded, int rightNeeded,
			int index, List<String> result) {
		if (leftNeeded == 0 && rightNeeded == 0) {
			result.add(String.valueOf(chars));
			return;
		}

		if (leftNeeded > 0) {
			chars[index] = '(';
			helper(chars, leftNeeded - 1, rightNeeded, index + 1, result);
		}
		if ( rightNeeded>leftNeeded) {
			chars[index] = ')';
			helper(chars, leftNeeded, rightNeeded - 1, index + 1, result);
		}

	}

	public static void main(String[] args) {
		ArrayList<String> list = generateParens(6);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println(list.size());
	}
}
