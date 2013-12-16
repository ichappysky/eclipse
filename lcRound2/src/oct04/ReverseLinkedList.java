package oct04;

import common.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ¡Ü m ¡Ü n ¡Ü length of list.
 * 
 * @author yongz
 * 
 */
public class ReverseLinkedList {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head;
		ListNode start = dummy;
		for (int i = 1; i < m; i++) {
			cur = cur.next;
			start = start.next;
		}
		ListNode next = cur.next;
		for (int i = m + 1; i <= n; i++) {
			ListNode tmp = next.next;

			next.next = cur;
			cur = next;
			next = tmp;
		}
		start.next.next = next;
		start.next = cur;
		return dummy.next;
	}
}