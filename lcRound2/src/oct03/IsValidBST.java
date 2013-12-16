package oct03;

import common.TreeNode;

public class IsValidBST {
	public boolean isValidBST(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean helper(TreeNode root, int low, int high) {
		if (root == null) {
			return true;
		}
		if (root.val <= low || root.val >= high) {
			return false;
		}
		if (!helper(root.left, low, root.val)) {
			return false;
		}
		return helper(root.right, root.val, high);
	}
}