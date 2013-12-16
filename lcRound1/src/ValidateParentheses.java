import java.util.Stack;

public class ValidateParentheses {
	public boolean isValid(String s) {
		if (s == null) {
			return false;
		}
		if (s.length() == 0) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		char firstChar = s.charAt(0);
		if (firstChar == ')' || firstChar == ']' || firstChar == '}') {
			return false;
		}
		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == ')' || cur == ']' || cur == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				char prev = stack.pop();
				if ((cur == ')' && prev != '(') || (cur == ']' && prev != '[')
						|| (cur == '}' && prev != '{')) {
					return false;
				}

			} else {
				stack.push(cur);
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] a) {
		ValidateParentheses t = new ValidateParentheses();
		System.out.println(t.isValid("()"));
	}
}