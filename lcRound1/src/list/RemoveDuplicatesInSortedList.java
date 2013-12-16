package list;
import common.ListNode;

public class RemoveDuplicatesInSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;

		while (cur != null) {
			if (prev == null) {
				prev = cur;
			} else if (prev.val != cur.val) {
				prev.next = cur;
				prev = cur;
			}
			cur = cur.next;
		}

		if (prev != null) {

			prev.next = null;
		}
		return head;
	}
}
