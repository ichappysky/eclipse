package list;

import common.ListNode;

public class MegeTwoSortedLinkList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode dummy = new ListNode(0);
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		ListNode end = dummy;
		while (cur1 != null && cur2 != null) {
			if (cur1.val < cur2.val) {
				end.next = cur1;
				cur1 = cur1.next;
			} else {
				end.next = cur2;
				cur2 = cur2.next;
			}
			end = end.next;
		}
		if (cur1 != null) {
			end.next = cur1;
		}
		if (cur2 != null) {
			end.next = cur2;
		}

		return dummy.next;
	}
}