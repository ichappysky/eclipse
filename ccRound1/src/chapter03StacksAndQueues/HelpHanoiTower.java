package chapter03StacksAndQueues;

import java.util.Stack;

public class HelpHanoiTower {
	public static void main(String[] args) {
		// Set up code.
		int n = 5;
		Tower[] towers = new Tower[3];
		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower();
		}
		for (int i = n - 1; i >= 0; i--) {
			towers[0].add(i);
		}

		towers[0].print();
		towers[0].moveDisks(n, towers[2], towers[1]);
		towers[2].print();
	}
}

class Tower {
	final private Stack<Integer> stack;

	public Tower() {
		stack = new Stack<Integer>();

	}

	public void add(int i) {
		stack.push(i);

	}

	public void moveDisks(int n, Tower destination, Tower buffer) {
		if (n == 0) {
			return;
		}
		this.moveDisks(n - 1, buffer, destination);
		moveTop(destination);
		buffer.moveDisks(n - 1, destination, this);

	}

	private void moveTop(Tower destination) {
		destination.add(this.stack.pop());

	}

	public void print() {
		System.out.println("Contents of Tower " + ": " + stack.toString());
	}

	public String toString() {
		return stack.toString();
	}
}