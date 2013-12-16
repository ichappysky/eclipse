package chapter04TreesAndGraphs;

import common.TreeNode;

public class ValidateBST {
	public static boolean checkBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	private static boolean helper(TreeNode root, int low, int high) {
		if (root == null) {
			return true;
		}

		if (root.data <= low || root.data >= high) {
			return false;
		}

		if (!helper(root.left, low, root.data)) {
			return false;
		}
		return helper(root.right, root.data, high);
	}

	public static void main(String[] args) {
		int[] array = { Integer.MIN_VALUE, Integer.MAX_VALUE - 2,
				Integer.MAX_VALUE - 1, Integer.MAX_VALUE };
		TreeNode node = TreeNode.createMinimalBST(array);
//		 node.left.data = 5;
//		 node.left.right.data = 3;
		node.print();
		System.out.println(checkBST(node));
	}
}
