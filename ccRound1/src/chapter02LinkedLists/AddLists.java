package chapter02LinkedLists;

import common.LinkedListNode;

public class AddLists {
	private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		LinkedListNode dummy = new LinkedListNode(0, null, null);
		LinkedListNode tail = dummy;
		int carry = 0;

		while (l1 != null || l2 != null) {
			int total = carry;
			if (l2 != null) {
				total += l2.data;
				l2 = l2.next;
			}
			if (l1 != null) {
				total += l1.data;
				l1 = l1.next;
			}
			carry = total / 10;
			tail.next = new LinkedListNode(total % 10, null, null);
			tail = tail.next;
		}
		if (carry > 0) {
			tail.next = new LinkedListNode(carry, null, null);
		}
		return dummy.next;
	}

	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		if (node.next != null) {
			value = 10 * linkedListToInt(node.next);
		}
		return value + node.data;
	}

	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(9, null, null);
		LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(9, null, lA2);

		LinkedListNode lB1 = new LinkedListNode(1, null, null);
		// LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
		// LinkedListNode lB3 = new LinkedListNode(0, null, lB2);

		LinkedListNode list3 = addLists(lA1, lB1);

		System.out.println(" " + lA1.printForward());
		System.out.println("+ " + lB1.printForward());
		System.out.println("= " + list3.printForward());

		int l1 = linkedListToInt(lA1);
		int l2 = linkedListToInt(lB1);
		int l3 = linkedListToInt(list3);

		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
	}
}
