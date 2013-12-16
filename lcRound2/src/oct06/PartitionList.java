package oct06;

import common.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * @author yongz
 * 
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		ListNode leftHead = new ListNode(0);
		ListNode leftTail = leftHead;
		ListNode rightHead = new ListNode(0);
		ListNode rightTail = rightHead;

		ListNode cur = head;
		while (cur != null) {
			if (cur.val < x) {
				leftTail.next = cur;
				leftTail = cur;
				cur = cur.next;
				leftTail.next = null;

			} else {
				rightTail.next = cur;
				rightTail = cur;
				cur = cur.next;
				rightTail.next = null;

			}
		}

		leftTail.next = rightHead.next;
		return leftHead.next;
	}
}
