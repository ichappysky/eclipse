package oct01;
import common.TreeNode;

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		return helper(root, 0);

	}

	private int helper(TreeNode root, int curTotal) {
		if (root == null) {
			return 0;
		}
		curTotal = curTotal * 10 + root.val;
		if (root.left == null && root.right == null) {
			return curTotal;
		}
		return helper(root.left, curTotal) + helper(root.right, curTotal);
	}
}