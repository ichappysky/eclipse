package list;

import common.ListNode;

public class ReverseNodesInKGroups {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k <= 0) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		for (int i = 0; head.next != null; head = head.next, i++) {
			if (i % k == 0) {
				head.next = helper(head.next, k);
			}
		}
		return dummy.next;
	}

	private ListNode helper(ListNode head, int k) {
		int i = 0;
		ListNode nextStart = head;
		for (; i < k && nextStart != null; i++) {
			nextStart = nextStart.next;

		}
		if (i < k) {
			return head;
		}
		ListNode next = head.next;
		head.next = nextStart;
		for (i = k; i > 1; i--) {
			ListNode tmp = next.next;
			next.next = head;
			head = next;
			next = tmp;
		}
		return head;
	}

	public static void main(String[] a) {
		ReverseNodesInKGroups t = new ReverseNodesInKGroups();

		ListNode h = new ListNode(1);
		h.next = new ListNode(2);
		h.next.next = new ListNode(3);
		h.next.next.next = new ListNode(4);
		h.next.next.next.next = new ListNode(5);
		System.out.println(t.reverseKGroup(h, 3));
	}
}