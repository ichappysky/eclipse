package oct21;

import common.ListNode;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode cur = dummy;
		while (cur.next != null && cur.next.next != null) {
			ListNode tmp = cur.next;
			cur.next = tmp.next;
			tmp.next = cur.next.next;
			cur.next.next = tmp;
			cur = tmp;
		}

		return dummy.next;
	}
}