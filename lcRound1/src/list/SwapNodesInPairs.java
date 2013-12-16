package list;

import common.ListNode;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		ListNode tmp = cur.next;
		while (cur.next != null && cur.next.next != null) {
			cur.next = tmp.next;
			tmp.next = tmp.next.next;
			cur.next.next = tmp;
			tmp = tmp.next;
			cur = cur.next.next;
		}
		return dummy.next;
	}
}
