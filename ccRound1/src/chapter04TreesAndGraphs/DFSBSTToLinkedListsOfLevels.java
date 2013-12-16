package chapter04TreesAndGraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import common.AssortedMethods;
import common.TreeNode;

public class DFSBSTToLinkedListsOfLevels {

	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(
			TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		if (root == null) {
			return result;
		}

		helper(root, 0, result);

		return result;
	}

	private static void helper(TreeNode root, int depth,
			ArrayList<LinkedList<TreeNode>> result) {
		if (root == null) {
			return;
		}
		if (result.size() == depth) {
			result.add(new LinkedList<TreeNode>());
		}

		result.get(depth).add(root);
		helper(root.left, depth + 1, result);
		helper(root.right, depth + 1, result);
	}

	public static void printResult(ArrayList<LinkedList<TreeNode>> result) {
		int depth = 0;
		for (LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while (i.hasNext()) {
				System.out.print(" " + ((TreeNode) i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}

	public static void main(String[] args) {
		int[] nodes_flattened = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		root.print();
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
	}
}
