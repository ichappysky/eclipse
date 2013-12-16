package list;
import common.ListNode;

public class ReverseLinkedList {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode beforeM = null;
		ListNode cur = dummy;
		ListNode next = head;
		ListNode mNode = null;
		for (int i=1; i<=n; i++ ) {
			if (i<=m) {
				if (i==m) {
					beforeM = cur;
					mNode = cur.next;
				}
				cur = cur.next;
				next = next.next;
			} else {
				ListNode tmp = next.next;
				next.next = cur;
				cur = next;
				next = tmp;
			}
		}
		mNode.next = next;
		beforeM.next = cur;
		return dummy.next;
	}

	public static void main(String[] args) {
		ReverseLinkedList t = new ReverseLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		t.reverseBetween(head, 1, 5);
	}
}