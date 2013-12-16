package ccRound2;

import java.util.Stack;

public class IsLinkedListPalindromeRecursive {
	public static boolean isPalindrome(LinkedListNode head) {
		if (head == null) {
			return true;
		}

		int len = getLen(head);
		Result result = helper(head, len);
		return result.isMatched;
	}

	private static Result helper(LinkedListNode head, int len) {
		if (head == null) {
			return new Result(null, true);
		}
		if (len == 1) {
			return new Result(head, true);
		}
		if (len == 2) {
			return new Result(head.next, head.data == head.next.data);
		}

		Result subResult = helper(head.next, len - 2);
		if (!subResult.isMatched) {
			return new Result(subResult.end.next, false);
		} else {
			return new Result(subResult.end.next,
					head.data == subResult.end.next.data);
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
		int length = 10;
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

class Result {
	boolean isMatched;
	LinkedListNode end;

	public Result(LinkedListNode end, boolean isMatched) {
		this.isMatched = isMatched;
		this.end = end;
	}
}

class LinkedListNode {
	public LinkedListNode next;
	public LinkedListNode prev;
	public LinkedListNode last;
	public int data;

	public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
		data = d;
		setNext(n);
		setPrevious(p);
	}

	public LinkedListNode() {
	}

	public void setNext(LinkedListNode n) {
		next = n;
		if (this == last) {
			last = n;
		}
		if (n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}

	public void setPrevious(LinkedListNode p) {
		prev = p;
		if (p != null && p.next != this) {
			p.setNext(this);
		}
	}

	public String printForward() {
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return ((Integer) data).toString();
		}
	}

	public LinkedListNode clone() {
		LinkedListNode next2 = null;
		if (next != null) {
			next2 = next.clone();
		}
		LinkedListNode head2 = new LinkedListNode(data, next2, null);
		return head2;
	}

	@Override
	public String toString() {
		return String.valueOf(this.data);
	}

}
