package oct06;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * @author yongz
 * 
 */
public class CopyListWithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}

		RandomListNode cur = head;
		// clone each node
		while (cur != null) {
			RandomListNode curCopy = new RandomListNode(cur.label);
			curCopy.next = cur.next;
			cur.next = curCopy;
			cur = curCopy.next;
		}

		// copy random relation
		cur = head;
		while (cur != null) {
			RandomListNode curCopy = cur.next;
			if (cur.random != null) {
				curCopy.random = cur.random.next;
			}
			cur = curCopy.next;
		}
		// break two lists
		RandomListNode copyHead = head.next;
		cur = head;
		RandomListNode curCopy = cur.next;
		while (cur != null) {
			cur.next = curCopy.next;
			cur = cur.next;
			if (cur != null) {
				curCopy.next = cur.next;
				curCopy = curCopy.next;
			}
		}

		return copyHead;

	}

	public static void main(String[] x) {
		RandomListNode n = new RandomListNode(1);
		// n.next = new RandomListNode(2);
		// n.next.next = new RandomListNode(2);
		// n.next.next.next = new RandomListNode(2);
		CopyListWithRandomPointer t = new CopyListWithRandomPointer();
		t.copyRandomList(n);
	}
}

class RandomListNode {
	public int label;
	public RandomListNode next, random;

	public RandomListNode(int x) {
		this.label = x;
	}
}