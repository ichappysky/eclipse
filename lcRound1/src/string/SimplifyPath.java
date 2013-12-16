package string;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String p) {
		if (p == null) {
			return null;
		}
		Stack<String> stack = new Stack<String>();
		String[] splits = p.split("/");
		for (String s : splits) {
			if (s.equals("") || s.equals(".")) {
				continue;
			} else if (s.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(s);
			}
		}
		String result = "";
		if (stack.isEmpty()) {
			return "/";
		}
		while (!stack.isEmpty()) {
			result = "/" + stack.pop() + result;
		}
		return result;
	}
}