package nov06;

import common.ListNode;

/**
 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn, reorder it to:
 * L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author yongz
 * 
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode tailHead = reverse(slow.next);
		slow.next = null;
		ListNode cur = head;
		// merge two lists
		while (tailHead != null) {
			ListNode tmp = tailHead.next;
			tailHead.next = cur.next;
			cur.next = tailHead;
			cur = tailHead.next;
			tailHead = tmp;
		}
	}

	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		ListNode next = cur.next;
		cur.next = null;
		while (next != null) {
			ListNode tmp = next.next;
			next.next = cur;
			cur = next;
			next = tmp;
		}
		return cur;
	}

	public static void main(String[] x) {
		ReorderList t = new ReorderList();
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);

		t.reorderList(head);
	}
}