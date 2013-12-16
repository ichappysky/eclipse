package oct21;

import common.ListNode;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n <= 0) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode back = dummy;
		ListNode front = back;
		while (n > 0 && front != null) {
			front = front.next;
			n--;
		}
		// n is larger than list size
		if (front == null) {
			return head;
		}
		while (front.next != null) {
			front = front.next;
			back = back.next;
		}
		back.next = back.next.next;
		return dummy.next;

	}
}