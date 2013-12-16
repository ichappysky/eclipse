package tree;

import common.TreeNode;

public class MaxPathSum {
	public int maxPathSum(TreeNode root) {
		Result r = helper(root);
		return r.maxOfAll;
	}

	private Result helper(TreeNode node) {
		if (node == null) {
			return new Result(0, Integer.MIN_VALUE);
		}

		Result left = helper(node.left);
		Result right = helper(node.right);

		// save max of (maxHalf+root, root)
		int maxWithNode = Math.max(
				node.val,
				Math.max(node.val + left.maxWithRoot, node.val
						+ right.maxWithRoot));

		//  max of (left_root_right, maxHalf_root, max out of lefttree, max
		// out of righttree)
		int max = Math.max(
				Math.max(maxWithNode, Math.max(left.maxOfAll, right.maxOfAll)),
				left.maxWithRoot + right.maxWithRoot + node.val);
		return new Result(maxWithNode, max);
	}

	public static void main(String[] args) {
		MaxPathSum t = new MaxPathSum();
		TreeNode x = new TreeNode(-3);

		System.out.println(t.maxPathSum(x));
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