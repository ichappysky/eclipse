import java.util.ArrayList;

public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		if (n <= 0) {
			return result;
		}
		char[] chars = new char[2 * n];
		helper(n, n, 0, chars, result);
		return result;
	}

	private void helper(int leftRemain, int rightRemain, int index,
			char[] chars, ArrayList<String> result) {
		if (leftRemain < 0 || rightRemain < 0) {
			return;
		}
		if (leftRemain == 0 && rightRemain == 0) {
			result.add(new String(chars));
		}

		if (leftRemain > 0) {
			chars[index] = '(';
			helper(leftRemain - 1, rightRemain, index + 1, chars, result);
		}
		if (rightRemain > leftRemain) {
			chars[index] = ')';
			helper(leftRemain, rightRemain - 1, index + 1, chars, result);
		}
	}

}
