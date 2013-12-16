package oct07;

import common.ListNode;

public class RemoveDuplicatesFromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		ListNode cur = head;
		int count = 1;
		while (cur != null) {
			if (cur.next == null) {
				if (count == 1) {
					tail.next = cur;
				}
				break;
			}
			if (cur.val == cur.next.val) {
				count++;
				cur = cur.next;
			} else {
				if (count == 1) {
					tail.next = cur;
					tail = cur;
					cur = cur.next;
					tail.next = null;
				} else {
					count = 1;
					cur = cur.next;
				}
				
			}
		}

		return dummy.next;
	}

	public static void main(String[] x) {
		ListNode n = new ListNode(1);
		n.next = new ListNode(1);
		n.next.next = new ListNode(2);
		RemoveDuplicatesFromSortedList2 t = new RemoveDuplicatesFromSortedList2();
		t.deleteDuplicates(n);
	}
}
