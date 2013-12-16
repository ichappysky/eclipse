package tree;

import common.TreeNode;

public class ConvertSortedArrayToBalancedBST {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}

		return helper(0, num.length - 1, num);
	}

	private TreeNode helper(int start, int end, int[] num) {
		if (end < start) {
			return null;
		}

		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(num[mid]);

		root.left = helper(start, mid - 1, num);
		root.right = helper(mid + 1, end, num);

		return root;
	}
}
