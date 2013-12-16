package oct09;

import common.ListNode;

public class MergeTwoSortedLinkList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tail.next = l1;
				tail = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				tail = l2;
				l2 = l2.next;
			}
		}
		if (l1 != null) {
			tail.next = l1;
		} else {
			tail.next = l2;
		}

		return dummy.next;
	}

}
