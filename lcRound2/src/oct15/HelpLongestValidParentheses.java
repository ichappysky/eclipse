package oct15;

import java.util.Stack;

public class HelpLongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int startIndex = -1;
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == '(') {
				stack.push(i);
				continue;
			}
			if (stack.isEmpty()) {
				startIndex = i;
				continue;
			}
			stack.pop();
			if (!stack.isEmpty()) {
				max = Math.max(max, i - stack.peek() );

			} else {
				max = Math.max(max, i - startIndex );
			}

		}
		return max;
	}
}