package oct02;

import common.TreeNode;

public class MaxDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.

		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return maxDepth(root.right) + 1;
		}

		if (root.right == null) {
			return maxDepth(root.left) + 1;
		}

		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
