package chapter03StacksAndQueues;

import java.util.Stack;

import common.AssortedMethods;

public class StackWithMin extends Stack<Integer> {
	final private Stack<Integer> minStack = new Stack<Integer>();

	public int getMin() {
		if (minStack.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return minStack.peek();
	}

	public void push(int i) {
		super.push(i);
		if (minStack.isEmpty() || i <= minStack.peek()) {
			minStack.push(i);
		}
	}

	public Integer pop() {
		int value = super.pop();
		if (value == minStack.peek()) {
			minStack.pop();
		}

		return value;
	}

	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		for (int i = 0; i < 15; i++) {
			int value = AssortedMethods.randomIntInRange(0, 100);
			stack.push(value);
			System.out.print(value + ", ");
		}
		System.out.println('\n');
		for (int i = 0; i < 15; i++) {
			System.out.println("Popped " + stack.pop());
			System.out.println("New min is " + stack.getMin());
		}
	}

}