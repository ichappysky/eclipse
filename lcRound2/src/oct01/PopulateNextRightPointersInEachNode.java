package oct01;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeLinkNode;

/**
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * @author yongz
 * 
 */
public class PopulateNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		int prevLayerNum = 1;
		int curLayerNum = 0;
		while (!queue.isEmpty()) {
			TreeLinkNode cur = queue.poll();
			prevLayerNum--;
			if (cur.left != null) {
				queue.offer(cur.left);
				curLayerNum++;
			}
			if (cur.right != null) {
				queue.offer(cur.right);
				curLayerNum++;
			}
			if (prevLayerNum == 0) {
				prevLayerNum = curLayerNum;
				curLayerNum = 0;
			} else {
				cur.next = queue.peek();
			}
		}
	}

}
