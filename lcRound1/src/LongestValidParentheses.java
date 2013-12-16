import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int startingIndex = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
				continue;
			}
			if (stack.isEmpty()) {
				startingIndex = i;
				continue;
			}
			stack.pop();
			if (stack.isEmpty()) {
				max = Math.max(max, i - startingIndex);
			} else {
				max = Math.max(max, i - stack.peek());
			}

		}
		return max;
	}

	public static void main(String[] a) {
		LongestValidParentheses t = new LongestValidParentheses();
		System.out.print(t.longestValidParentheses("()))(())"));
	}
}