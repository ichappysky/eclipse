package tree;

import java.util.ArrayDeque;
import java.util.Deque;

import common.TreeNode;

public class MinDepthBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// DFS it
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		int min = Integer.MAX_VALUE;
		TreeNode cur = root;
		TreeNode prev = null;
		stack.push(root);

		while (!stack.isEmpty()) {
			cur = stack.peek();
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null) {
					stack.push(cur.left);
				} else if (cur.right != null) {
					stack.push(cur.right);
				}
			} else if (cur.left == prev) {
				if (cur.right != null) {
					stack.push(cur.right);
				}
			} else {
    			if (cur.left==null && cur.right== null &&stack.size() < min) {
    				min = stack.size();
    			}
    			stack.pop();
			}

			prev = cur;
		}
		return min;

	}

}
