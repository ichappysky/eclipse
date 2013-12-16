package list;
import common.ListNode;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}

		ListNode smallStart = new ListNode(0);
		ListNode smallEnd = smallStart;
		ListNode largeStart = new ListNode(0);
		ListNode largeEnd = largeStart;

		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			if (cur.val < x) {
				smallEnd.next = cur;
				smallEnd = cur;
			} else {
				largeEnd.next = cur;
				largeEnd = cur;
				largeEnd.next = null;
			}
			cur = next;
		}
		smallEnd.next = largeStart.next;
		return smallStart.next;
	}

	public static void main(String[] args) {
		PartitionList t = new PartitionList();
		ListNode a = new ListNode(1);
		// a.next = new ListNode(1);
		System.out.println(t.partition(a, 1));
	}
}