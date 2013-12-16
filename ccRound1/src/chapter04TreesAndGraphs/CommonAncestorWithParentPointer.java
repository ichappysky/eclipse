package chapter04TreesAndGraphs;

import common.TreeNode;

public class CommonAncestorWithParentPointer {

	public static TreeNode commonAncestor(TreeNode root, TreeNode a, TreeNode b) {
		int aHeight = getHeight(a);
		int bHeight = getHeight(b);
		int diff = Math.abs(aHeight - bHeight);
		if (aHeight > bHeight) {
			while (diff > 0) {
				a = a.parent;
				diff--;
			}
		} else {
			while (diff > 0) {
				b = b.parent;
				diff--;
			}
		}

		while (a != b) {
			a = a.parent;
			b = b.parent;
		}
		return a;
	}

	private static int getHeight(TreeNode node) {
		int count = 0;
		while (node.parent != null) {
			count++;
			node = node.parent;
		}
		return count;
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
