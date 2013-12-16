package nov06;

import java.util.ArrayList;
import java.util.Stack;

import common.TreeNode;

public class PreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				result.add(root.val);
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				root = root.right;
			}
		}

		return result;
	}
}
