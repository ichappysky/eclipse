package chapter02LinkedLists;

import common.LinkedListNode;

public class FindBeginningNodeOfLoop {
	public static LinkedListNode FindBeginning(LinkedListNode head) {

		LinkedListNode fast = head.next.next;
		LinkedListNode slow = head.next;
		while (fast != slow) {
			fast = fast.next.next;
			slow = slow.next;
		}

		slow = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		int list_length = 100;
		int k = 99;

		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}

		// Create loop;
		nodes[list_length - 1].next = nodes[k];

		LinkedListNode loop = FindBeginning(nodes[0]);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.data == k);
		}
	}

}
