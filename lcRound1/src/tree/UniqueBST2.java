package tree;

import java.util.ArrayList;

import common.TreeNode;

public class UniqueBST2 {
	public ArrayList<TreeNode> generateTrees(int n) {
		return helper(1, n);
	}

	private ArrayList<TreeNode> helper(int start, int end) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end) {
			result.add(null);
			return result;
		}
		if (start == end) {
			result.add(new TreeNode(start));
			return result;
		}

		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> leftTrees = helper(start, i - 1);
			ArrayList<TreeNode> rightTrees = helper(i + 1, end);

			for (TreeNode left : leftTrees) {
				for (TreeNode right : rightTrees) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					result.add(root);
				}
			}
		}

		return result;
	}
}