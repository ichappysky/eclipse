package list;

import common.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode end = head;
		int size = 1;
		while (end.next != null) {
			end = end.next;
			size++;
		}
		end.next = head;
		int movesNeeded  = size - n%size;
		while (movesNeeded> 0) {
			head = head.next;
			end = end.next;
			movesNeeded--;
		}
		end.next = null;
		return head;
	}
}