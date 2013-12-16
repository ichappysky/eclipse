package chapter17Moderate;

public class BinaryTreeToDoublyLinkedList {
	public static NodePair convert(BiNode root) {
		if (root == null) {
			return null;
		}
		NodePair result = new NodePair(null, null);

		NodePair left = convert(root.node1);
		if (left != null) {
			result.head = left.head;
			left.tail.node2 = root;
			root.node1 = left.tail;
		} else {
			result.head = root;
		}

		NodePair right = convert(root.node2);
		if (right != null) {
			result.tail = right.tail;
			right.head.node1 = root;
			root.node2 = right.head;
		} else {
			result.tail = root;
		}
		return result;

	}

	// =====================
	public static void main(String[] args) {
		BiNode root = createTree();
		printAsTree(root, "");
		NodePair n = convert(root);
		printLinkedListTree(n.head);
	}

	public static void printLinkedListTree(BiNode root) {
		for (BiNode node = root; node != null; node = node.node2) {
			if (node.node2 != null && node.node2.node1 != node) {
				System.out.print("inconsistent node: " + node);
			}
			System.out.print(node.data + "->");
		}
		System.out.println();
	}

	public static BiNode createTree() {
		BiNode[] nodes = new BiNode[7];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new BiNode(i);
		}
		nodes[4].node1 = nodes[2];
		nodes[4].node2 = nodes[5];
		nodes[2].node1 = nodes[1];
		nodes[2].node2 = nodes[3];
		nodes[5].node2 = nodes[6];
		nodes[1].node1 = nodes[0];
		return nodes[4];
	}

	public static void printAsTree(BiNode root, String spaces) {
		if (root == null) {
			System.out.println(spaces + "- null");
			return;
		}
		System.out.println(spaces + "- " + root.data);
		printAsTree(root.node1, spaces + " ");
		printAsTree(root.node2, spaces + " ");
	}

}

class BiNode {
	public BiNode node1;
	public BiNode node2;
	public int data;

	public BiNode(int d) {
		data = d;
	}
}

class NodePair {
	public BiNode head;
	public BiNode tail;

	public NodePair(BiNode head, BiNode tail) {
		this.head = head;
		this.tail = tail;
	}
}
