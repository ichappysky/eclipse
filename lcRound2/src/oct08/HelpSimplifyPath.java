package oct08;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 * 
 * @author yongz
 * 
 */
public class HelpSimplifyPath {
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return "";
		}
		Stack<String> stack = new Stack<String>();
		String[] splits = path.split("/");
		for (String cur : splits) {
			if (cur.isEmpty() || cur.equals(".")) {
				continue;
			} else if (cur.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(cur);
			}
		}
		if (stack.isEmpty()) {
			return "/";
		}
		String result = "";
		while (!stack.isEmpty()) {
			result = "/" + stack.pop() + result;
		}

		return result;
	}

	public static void main(String[] x) {
		HelpSimplifyPath t = new HelpSimplifyPath();
		System.out.println(t.simplifyPath("./../ab"));
	}
}