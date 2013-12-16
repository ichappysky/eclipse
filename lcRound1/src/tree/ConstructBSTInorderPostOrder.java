package tree;

import common.TreeNode;

public class ConstructBSTInorderPostOrder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder == null || inorder == null
				|| postorder.length != inorder.length) {
			return null;
		}

		return helper(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);
	}

	private TreeNode helper(int[] inorder, int startIn, int endIn,
			int[] postorder, int startPost, int endPost) {
		if (startPost > endPost || startIn > endIn) {
			return null;
		}

		int rootVal = postorder[endPost];
		TreeNode root = new TreeNode(rootVal);
		int rootIndexOfInorder = startIn;
		while (rootIndexOfInorder <= endIn) {
			if (inorder[rootIndexOfInorder] == rootVal) {
				break;
			}
			rootIndexOfInorder++;
		}
		int leftTreeSize = rootIndexOfInorder - startIn;

		root.left = helper(inorder, startIn, rootIndexOfInorder - 1, postorder,
				startPost, startPost + leftTreeSize - 1);
		root.right = helper(inorder, rootIndexOfInorder + 1, endIn, postorder,
				startPost + leftTreeSize, endPost - 1);
		return root;
	}
}