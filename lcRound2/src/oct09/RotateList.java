package oct09;

import common.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || head.next == null) {
			return head;
		}

		ListNode tail = head;
		int len = 1;
		while (tail.next != null) {
			tail = tail.next;
			len++;
		}
		int steps = len-n % len;

		tail.next = head;
		while (steps > 0) {
			tail = tail.next;
			steps--;
		}

		ListNode newHead = tail.next;
		// break loop
		tail.next = null;
		return newHead;
	}
}