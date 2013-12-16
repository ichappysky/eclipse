package tree;

import common.TreeNode;

public class IsBalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		int leftHeight = getHeight(root.left);
		if (leftHeight < 0) {
			return false;
		}
		int rightHeight = getHeight(root.right);
		if (rightHeight < 0) {
			return false;
		}

		return Math.abs(leftHeight - rightHeight) <= 1;
	}

	// return -1 if unbalanced.
	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = getHeight(root.left);
		if (leftHeight < 0) {
			return leftHeight;
		}
		int rightHeight = getHeight(root.right);
		if (rightHeight < 0) {
			return rightHeight;
		}

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;

	}

}