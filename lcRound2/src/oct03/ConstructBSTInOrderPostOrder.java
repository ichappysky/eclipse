package oct03;

import common.TreeNode;

public class ConstructBSTInOrderPostOrder {
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

		if (startIn > endIn || startPost > endPost) {
			return null;
		}

		int rootVal = postorder[endPost];
		TreeNode root = new TreeNode(rootVal);
		int rootIndex = startIn;
		while (inorder[rootIndex] != rootVal) {
			rootIndex++;
		}
		int leftTreeSize = rootIndex - startIn;
		root.left = helper(inorder, startIn, rootIndex - 1, postorder,
				startPost, startPost + leftTreeSize - 1);
		root.right = helper(inorder, rootIndex + 1, endIn, postorder, startPost
				+ leftTreeSize, endPost - 1);
		return root;

	}

}
