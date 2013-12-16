package tree;

import java.util.ArrayDeque;
import java.util.Deque;

import common.TreeNode;

public class PreOrderTraversal {
	public void traverseIterative(TreeNode root) {
		Deque<TreeNode> s = new ArrayDeque<TreeNode>();
		TreeNode cur = root;
		while (!s.isEmpty() || cur != null) {
			if (cur != null) {
				System.out.println(cur.val);
				s.push(cur);
				cur = cur.left;
			} else {
				cur = s.pop();
				cur = cur.right;
			}
		}
	}

	public void traverseRecursive(TreeNode root) {
		if (root == null) {
			return;
		}
		// print root first
		System.out.println(root.val);
		traverseRecursive(root.left);
		traverseRecursive(root.right);
	}
}
