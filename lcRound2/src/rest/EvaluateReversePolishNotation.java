package rest;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();

		for (String cur : tokens) {
			if (cur.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (cur.equals("-")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b - a);
			} else if (cur.equals("*")) {

				stack.push(stack.pop() * stack.pop());
			} else if (cur.equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b / a);
			} else {
				stack.push(Integer.valueOf(cur));
			}
		}
		return stack.pop();
	}
}
