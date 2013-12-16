package oct21;

import java.util.Stack;

public class ValidateParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == '(' || cur == '{' || cur == '[') {
				stack.push(cur);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.peek();
				if (isPair(top, cur)) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	private boolean isPair(char left, char right) {
		return (left == '(' && right == ')') || (left == '[' && right == ']')
				|| (left == '{' && right == '}');
	}

}
