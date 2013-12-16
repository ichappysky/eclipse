package chapter04TreesAndGraphs;

import common.TreeNode;

public class BalancedBinaryTree {
	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		return getHeight(root) >=0;
	}

	private static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = getHeight(root.left);
		if (leftHeight < 0) {
			return leftHeight;
		}
		int rightHeight = getHeight(root.right);
		if (rightHeight < 0) {
			return rightHeight;
		}
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String[] args) {
		// Create balanced tree
		int[] array = { 0, 1, 2, 3, 5, 6, 7, 8, 9, 10 };
		TreeNode root = TreeNode.createMinimalBST(array);

		System.out.println("Is balanced? " + isBalanced(root));

		root.insertInOrder(4); // Add 4 to make it unbalanced

		System.out.println("Is balanced? " + isBalanced(root));
	}
}
