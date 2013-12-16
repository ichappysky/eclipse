package oct22;

import common.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode dummy = new ListNode(0);
		ListNode end = dummy;
		int carry = 0;
		while (l1 != null || l2 != null || carry > 0) {
			int cur = carry;
			if (l1 != null) {
				cur += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				cur += l2.val;
				l2 = l2.next;
			}
			carry = cur / 10;
			end.next = new ListNode(cur % 10);
			end = end.next;

		}
		return dummy.next;
	}
}
