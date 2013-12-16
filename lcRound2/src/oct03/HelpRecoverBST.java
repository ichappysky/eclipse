package oct03;

import java.util.Stack;

import common.TreeNode;

public class HelpRecoverBST {
	public void q(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		// stack.push(root);
		TreeNode prev = null;
		TreeNode cur = root;
		TreeNode first = null;
		TreeNode second = null;
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				if (prev != null && prev.val > cur.val) {
					if (first == null) {
						first = prev;
					}
					second = cur;

				}
				prev = cur;

				cur = cur.right;
			}
		}

		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}
}
