package chapter02LinkedLists;

import java.util.Stack;

import common.LinkedListNode;

public class IsPalindromeIterative {
	public static boolean isPalindrome(LinkedListNode head) {
		if (head == null) {
			return true;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int len = getLen(head);
		boolean hasOddNodes = len % 2 == 1;
		for (int i = 0; i < len / 2; i++) {
			stack.push(head.data);
			head = head.next;
		}
		if (hasOddNodes) {
			head = head.next;
		}
		while (!stack.isEmpty()) {
			if (stack.pop()!= head.data) {
				return false;
			}
			head = head.next;
		}
		return true;

	}

	private static int getLen(LinkedListNode n) {
		int len = 0;
		while (n != null) {
			len++;
			n = n.next;
		}
		return len;
	}

	public static void main(String[] args) {
		int length = 2;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i,
					null, null);
		}

		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		 nodes[length - 2].data = 9; // Uncomment to ruin palindrome

		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		System.out.println(isPalindrome(head));
	}
}
