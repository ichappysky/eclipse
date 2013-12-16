package oct02;

import java.util.ArrayList;

import common.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}

		ArrayList<TreeNode> curLayer = new ArrayList<TreeNode>();
		curLayer.add(root);
		while (!curLayer.isEmpty()) {
			ArrayList<TreeNode> nextLayer = new ArrayList<TreeNode>();
			ArrayList<Integer> resultLayer = new ArrayList<Integer>();
			for (TreeNode n : curLayer) {
				resultLayer.add(n.val);
				if (n.left != null) {
					nextLayer.add(n.left);
				}
				if (n.right != null) {
					nextLayer.add(n.right);
				}
			}

			curLayer = nextLayer;
			// bottom up one ---
			// result.add(0, resultLayer);
			result.add(resultLayer);
		}
		return result;

	}

}
