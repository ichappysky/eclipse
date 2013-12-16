package chapter02LinkedLists;

import common.LinkedListNode;

public class PartitionList {
	public static LinkedListNode partition(LinkedListNode node, int x) {
		if (node == null) {
			return null;
		}

		LinkedListNode smallHead = new LinkedListNode(0, null, null);
		LinkedListNode smallTail = smallHead;
		LinkedListNode largeHead = new LinkedListNode(0, null, null);
		LinkedListNode largeTail = largeHead;
		while (node != null) {
			if (node.data < x) {
				smallTail.next = node;
				smallTail = node;
			} else {
				largeTail.next = node;
				largeTail = node;
			}
			node = node.next;
		}
		smallTail.next = largeHead.next;
		largeTail.next = null;
		return smallHead.next;
	}

	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = { 1, 3, 7, 5, 2, 9, 4 };
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());

		/* Partition */
		LinkedListNode h = partition(head, 4);

		/* Print Result */
		System.out.println(h.printForward());
	}

}
