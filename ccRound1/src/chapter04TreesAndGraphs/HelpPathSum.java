package chapter04TreesAndGraphs;

import common.TreeNode;

public class HelpPathSum {

	public static void findSum(TreeNode root, int sum) {
		if (root == null) {
			return;
		}

		int depth = getHeight(root);
		int[] path = new int[depth];

		helper(root, sum, path, 0);

	}

	private static void helper(TreeNode root, int sum, int[] path, int level) {
		if (root == null) {
			return;
		}

		path[level] = root.data;
		int total = 0;
		for (int i = level; i >= 0; i--) {
			total += path[i];
			if (total == sum) {
				print(path, i, level);
			}
		}
		helper(root.left, sum, path, level + 1);
		helper(root.right, sum, path, level + 1);
	}

	private static int getHeight(TreeNode r) {
		if (r == null) {
			return 0;
		}

		return Math.max(getHeight(r.left), getHeight(r.right)) + 1;

	}

	private static void print(int[] path, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);
		root.print();
		findSum(root, 3);
	}
}
