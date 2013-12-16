package tree;

import common.TreeNode;

public class FlatBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		flatten(root.left);
		flatten(root.right);
		if (root.left == null) {
			return;
		}
		// go to leaf node of left tree
		TreeNode cur = root.left;
		while (cur.right != null) {
			cur = cur.right;
		}
		if (cur != null) {
			cur.right = root.right;
		}
		root.right = root.left;
		root.left = null;

	}
}
