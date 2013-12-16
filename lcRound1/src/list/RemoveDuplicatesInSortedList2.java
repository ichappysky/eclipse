package list;
import common.ListNode;

public class RemoveDuplicatesInSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head;
		ListNode prev = null;
		ListNode prevPrev = null;

		while (cur != null) {
			if (prev == null) {
				prev = cur;
				prevPrev = dummy;
			} else if (cur.val != prev.val) {
				// duplicates in between prev and cur
				if (prev.next != cur) {
					prevPrev.next = cur;
				} else {
					prevPrev = prev;
				}
				prev = cur;
			}

			cur = cur.next;

		}
		// the last piece has duplicates
		if (prev != null && prev.next != null) {
			prevPrev.next = null;
		}

		return dummy.next;

	}
}