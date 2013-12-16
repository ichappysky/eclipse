package chapter02LinkedLists;

import common.LinkedListNode;

public class HelpIsPalindromeRecursive {
	public static boolean isPalindrome(LinkedListNode head) {
		if (head == null) {
			return true;
		}

		int len = getLen(head);
		return helper(head, len).isPalindrome;
	}

	private static Result helper(LinkedListNode n, int len) {
		if (len == 0) {
			return new Result(null, true);
		}
		if (len == 1) {
			return new Result(n, true);
		}
		if (len == 2) {
			return new Result(n.next, n.data == n.next.data);
		}
		Result subResult = helper(n.next, len - 2);
		LinkedListNode curTail = subResult.tail.next;
		if (!subResult.isPalindrome || n.data != curTail.data) {
			return new Result(curTail, false);
		} else {
			return new Result(curTail, true);
		}
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
		int length = 11;
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
//		 nodes[length - 2].data = 9; // Uncomment to ruin palindrome

		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		System.out.println(isPalindrome(head));
	}

}

class Result {
	public LinkedListNode tail;
	public boolean isPalindrome;

	public Result(LinkedListNode tail, boolean isPalindrome) {
		this.tail = tail;
		this.isPalindrome = isPalindrome;
	}
}