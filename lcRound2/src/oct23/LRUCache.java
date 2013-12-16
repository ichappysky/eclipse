package oct23;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	// a map from key to the underlying node;
	private Map<Integer, Node> cacheMap = null;
	// max size of cache
	private int cacheSize = 0;
	// head of doubly linked list
	private Node head = null;
	// tail
	private Node tail = null;

	public void set(int key, int value) {
		if (!cacheMap.containsKey(key)) {
			Node node = new Node(key, value);
			insertToHead(node);
			if (cacheMap.size() > cacheSize) {
				removeNode(this.tail);
			}
		} else {
			Node node = cacheMap.get(key);
			node.val = value;
			removeNode(node);
			insertToHead(node);
		}
	}

	public int get(int key) {

		if (!cacheMap.containsKey(key)) {
			return -1;
		}
		Node node = cacheMap.get(key);
		removeNode(node);
		insertToHead(node);

		return node.val;
	}

	private void removeNode(Node node) {

		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		if (tail == node) {
			tail = node.prev;
		}
		node.prev = null;
		node.next = null;

		cacheMap.remove(node.key);
	}

	// insert node to head
	private void insertToHead(Node node) {

		node.prev = head;
		node.next = head.next;
		if (head.next != null) {
			head.next.prev = node;
		} else {
			tail = node;
		}
		head.next = node;

		cacheMap.put(node.key, node);
	}

	public void initialize(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Positive size is required "
					+ size);
		}
		cacheMap = new HashMap<Integer, Node>();
		head = new Node(0, 0);
		tail = head;
		this.cacheSize = size;
	}

	public LRUCache(int capacity) {
		initialize(capacity);
	}

	public static void main(String[] x) {
		LRUCache t = new LRUCache(1);

		t.set(2, 1);
		System.out.println(t.get(2));
		t.set(3, 2);
		System.out.println(t.get(2));
		System.out.println(t.get(3));

	}

}

class Node {
	// make them public for simplicity
	public int key;
	public int val;
	public Node prev;
	public Node next;

	public Node(int key, int val) {
		this.key = key;
		this.val = val;
	}

	public String toString() {
		return "key: " + this.key + ", value=" + this.val;
	}
}