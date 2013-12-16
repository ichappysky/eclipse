package chapter02LinkedLists;

import common.LinkedListNode;

public class AddLists2 {
	private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		int len1 = getLen(l1);
		int len2 = getLen(l2);
		PartialResult result;
		if (len1 > len2) {
			result = helper(l1, l2, len1 - len2);
		} else {
			result = helper(l2, l1, len2 - len1);
		}
		if (result.carry == 0) {
			return result.sum;
		}
		LinkedListNode f = new LinkedListNode(result.carry, null, null);
		f.next = result.sum;
		return f;

	}

	private static PartialResult helper(LinkedListNode l1, LinkedListNode l2,
			int lenDiff) {
		PartialResult prevResult = null;
		if (l1 == null && l2 == null) {
			return new PartialResult(null, 0);
		}
		int total = l1.data;
		if (lenDiff > 0) {
			prevResult = helper(l1.next, l2, lenDiff-1);
		} else {
			prevResult = helper(l1.next, l2.next, 0);
			total += l2.data;
		}
		total += prevResult.carry;
		LinkedListNode curSum = new LinkedListNode(total % 10, null, null);
		curSum.next = prevResult.sum;
		return new PartialResult(curSum, total / 10);

	}

	private static int getLen(LinkedListNode n) {
		int len = 0;
		while (n != null) {
			len++;
			n = n.next;
		}
		return len;
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
		LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
//		LinkedListNode lA3 = new LinkedListNode(5, null, lA2);

		LinkedListNode lB1 = new LinkedListNode(9, null, null);
		LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(1, null, lB2);

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

class PartialResult {
	LinkedListNode sum = null;
	int carry = 0;

	public PartialResult(LinkedListNode sum, int carry) {
		this.sum = sum;
		this.carry = carry;
	}
}