package chapter04TreesAndGraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import common.AssortedMethods;
import common.TreeNode;

public class BetterSolutionBSTToLinkedListsOfLevels {

	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(
			TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> curList = new LinkedList<TreeNode>();
		curList.add(root);
		while (!curList.isEmpty()) {
			result.add(curList);
			LinkedList<TreeNode> parent = curList;
			curList = new LinkedList<TreeNode>();
			for (TreeNode node : parent) {
				if (node.left != null) {
					curList.add(node.left);
				}
				if (node.right != null) {
					curList.add(node.right);
				}
			}
		}

		return result;
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
