package list;

import common.ListNode;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (n <= 0 || head == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode forward = dummy;
		ListNode behind = dummy;
		while (n > 0 && forward != null) {
			forward = forward.next;
			n--;
		}
		if (n > 0) {
			return dummy.next;
		}
		while (forward.next != null) {
			forward = forward.next;
			behind = behind.next;

		}
		behind.next = behind.next.next;

		return dummy.next;
	}
}