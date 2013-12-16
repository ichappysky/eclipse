package chapter02LinkedLists;

import common.AssortedMethods;
import common.LinkedListNode;

public class FindKthNodeFromEnd {
	public static LinkedListNode nthToLast(LinkedListNode head, int n) {
		if (head == null || n<=0) {
			return null;
		}
		LinkedListNode runner = head;
		while (n > 0 && runner != null) {
			runner = runner.next;
			n--;
		}

		if (n > 0) {
			return null;
		}
		LinkedListNode cur = head;
		while (runner != null) {
			cur = cur.next;
			runner = runner.next;
		}
		return cur;

	}

	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		int nth = 0;
		LinkedListNode n = nthToLast(head, nth);
		System.out.println(n.printForward());
	}
}
