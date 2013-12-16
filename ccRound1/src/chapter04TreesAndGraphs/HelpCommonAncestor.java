package chapter04TreesAndGraphs;

import common.TreeNode;

public class HelpCommonAncestor {
	public static TreeNode commonAncestor(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null) {
			return null;
		}
		
		 if (root == a || root == b) return root;

		TreeNode left = commonAncestor(root.left, a, b);
		TreeNode right = commonAncestor(root.right, a, b);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		root.print();
		TreeNode n3 = root.find(7);
		TreeNode n7 = root.find(10);
		TreeNode ancestor = commonAncestor(root, n3, n7);
		System.out.println(ancestor.data);
	}
}
