package chapter02LinkedLists;

import java.util.HashSet;
import java.util.Set;

import common.LinkedListNode;

public class HelpRemoveDuplicates {
	public static void deleteDupsA(LinkedListNode n) {
		if (n == null) {
			return;
		}

		LinkedListNode prev = null;
		LinkedListNode cur = n;
		Set<Integer> set = new HashSet<Integer>();
		while (cur != null) {
			if (!set.contains(cur.data)) {
				set.add(cur.data);
				prev = cur;
			} else {
				prev.next = cur.next;
			}
			cur = cur.next;
		}
	}

	public static void main(String[] args) {
		LinkedListNode first = new LinkedListNode(0, null, null); // AssortedMethods.randomLinkedList(1000,
																	// 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 2, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		deleteDupsA(head);
		System.out.println(head.printForward());

	}

}
