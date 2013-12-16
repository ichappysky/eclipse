package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointers {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		int prevLayerNum = 1;
		int curLayerNum = 0;
		TreeLinkNode prevNode = null;
		while (!queue.isEmpty()) {
			prevLayerNum--;
			TreeLinkNode curNode = queue.poll();
			if (prevNode != null) {
				prevNode.next = curNode;
			}
			if (curNode.left != null) {
				queue.offer(curNode.left);
				curLayerNum++;
			}
			if (curNode.right != null) {
				queue.offer(curNode.right);
				curLayerNum++;
			}

			// end of layer
			if (prevLayerNum == 0) {
				prevLayerNum = curLayerNum;
				curLayerNum = 0;
				prevNode = null;
			} else {
				prevNode = curNode;
			}
		}

	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}