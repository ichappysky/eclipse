package chapter03StacksAndQueues;

import java.util.Stack;

import common.AssortedMethods;

public class HelpStackSort {
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while (!r.isEmpty() &&r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}

	public static void main(String[] args) {
		for (int k = 1; k < 100; k++) {
			Stack<Integer> s = new Stack<Integer>();
			for (int i = 0; i < 10 * k; i++) {
				int r = AssortedMethods.randomIntInRange(0, 5);
				s.push(r);
			}
			s = sort(s);
			int last = Integer.MAX_VALUE;
			while (!s.isEmpty()) {
				int curr = s.pop();
				if (curr > last) {
					System.out.println("Error: " + last + " " + curr);
				}
				last = curr;
			}
			
		}
	}
}
