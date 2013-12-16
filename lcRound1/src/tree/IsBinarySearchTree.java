package tree;

import java.util.ArrayDeque;
import java.util.Deque;

import common.TreeNode;

public class IsBinarySearchTree {

	// in-order traverse it and check ordering along the way.
	public boolean isValidBST(TreeNode root) {
		TreeNode cur = root;
		Deque<TreeNode> d = new ArrayDeque<TreeNode>();
		Integer prev = null;
		while (!d.isEmpty() || cur != null) {
			if (cur != null) {
				d.push(cur);
				cur = cur.left;
			} else {
				cur = d.pop();
				if (prev != null && prev > cur.val) {
					return false;
				}
				prev = cur.val;
				cur = cur.right;

			}
		}

		return true;

	}

	// update (min, max) range. left tree range is (previous min, root.value),
	// right tree range is (root.value, previous.max);
	public boolean validateRecursive(TreeNode root) {

		return validateRecursiveHelper(root, Integer.MIN_VALUE,
				Integer.MAX_VALUE);
	}

	private boolean validateRecursiveHelper(TreeNode r, int min, int max) {
		if (r.val <= min || r.val > max) {
			return false;
		}
		return validateRecursiveHelper(r.left, min, r.val)
				&& validateRecursiveHelper(r.right, r.val, max);
	}
}
