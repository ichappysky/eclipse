package nov06;

import common.ListNode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode fast = head.next.next;
		ListNode slow = head;
		while (fast != slow) {
			if (fast == null || fast.next == null) {
				return false;
			}
			fast = fast.next.next;
			slow = slow.next;
		}

		return true;
	}
}
