package oct21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import common.ListNode;

public class MergeKSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.isEmpty()) {
			return null;
		}

		Comparator<ListNode> comparator = new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1 == null && o2 == null) {
					return 0;
				}
				if (o1 == null || o2 == null) {
					throw new IllegalArgumentException();
				}
				if (o1.val == o2.val) {
					return 0;
				} else if (o1.val < o2.val) {
					return -1;
				} else {
					return 1;
				}
			}
		};

		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
				lists.size(), comparator);
		for (ListNode node : lists) {
			if (node != null) {
				heap.offer(node);
			}
		}
		ListNode dummy = new ListNode(0);
		ListNode end = dummy;
		while (!heap.isEmpty()) {
			end.next = heap.poll();
			end = end.next;
			if (end.next != null) {
				heap.offer(end.next);
			}
		}

		return dummy.next;

	}
}
