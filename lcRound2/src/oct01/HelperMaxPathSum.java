package oct01;

import common.TreeNode;

/**
 * Given a binary tree, find the maximum path sum. The path may start and end at
 * any node in the tree. For example: Given the below binary tree, 
 *   1 
 *  / \
 *  2  3
 * Return 6.
 * 
 * 
 * @author yongz
 * 
 */
public class HelperMaxPathSum {
	public int maxPathSum(TreeNode root) {
		Result r = helper(root);
		return r.maxOfAll;

	}

	private Result helper(TreeNode root) {
		if (root == null) {
			return new Result(0, Integer.MIN_VALUE);
		}

		Result left = helper(root.left);
		Result right = helper(root.right);
		int maxWithRoot = Math.max(
				Math.max(left.maxWithRoot, right.maxWithRoot) + root.val,
				root.val);
		int maxOfAll = Math.max(
				Math.max(Math.max(left.maxOfAll, right.maxOfAll), maxWithRoot),
				left.maxWithRoot + right.maxWithRoot + root.val);
		return new Result(maxWithRoot, maxOfAll);
	}

	public static void main(String[] a) {
		HelperMaxPathSum t = new HelperMaxPathSum();
		System.out.println(t.maxPathSum(new TreeNode(-3)));
	}
}

class Result {
	public int maxWithRoot;
	public int maxOfAll;

	public Result(int a, int b) {
		this.maxWithRoot = a;
		this.maxOfAll = b;
	}
}
