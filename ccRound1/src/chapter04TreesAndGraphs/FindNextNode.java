package chapter04TreesAndGraphs;

import common.TreeNode;

public class FindNextNode {

	public static TreeNode inorderSucc(TreeNode node) {
		if (node == null) {
			return null;
		}

		
		if (node.right != null) {
			node = node.right;
			while (node.left != null) {
				node = node.left;
			}
			return node;
		}
		while (node.parent != null) {

			if (node.parent.left == node) {
				return node.parent;
			} else {
				node = node.parent;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		root.print();
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = inorderSucc(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}
}
