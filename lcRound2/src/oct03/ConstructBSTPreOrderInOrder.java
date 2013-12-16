package oct03;

import common.TreeNode;

public class ConstructBSTPreOrderInOrder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null
				|| preorder.length != inorder.length) {
			return null;
		}

		return helper(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
	}

	private TreeNode helper(int[] preorder, int startPre, int endPre,
			int[] inorder, int startIn, int endIn) {

		if (startPre > endPre || startIn > endIn) {
			return null;
		}

		int rootVal = preorder[startPre];
		TreeNode root = new TreeNode(rootVal);
		int rootIndexInInorder = startIn;
		while (inorder[rootIndexInInorder] != rootVal) {
			rootIndexInInorder++;
		}
		int leftTreeSize = rootIndexInInorder - startIn;
		root.left = helper(preorder, startPre + 1, startPre + leftTreeSize ,
				inorder, startIn, rootIndexInInorder - 1);
		root.right = helper(preorder, startPre + leftTreeSize + 1, endPre,
				inorder, rootIndexInInorder + 1, endIn);
		return root;
	}

	public static void main(String[] x) {
		ConstructBSTPreOrderInOrder t = new ConstructBSTPreOrderInOrder();
		t.buildTree(new int[] {1,2}, new int[]{2,1});
	}
}
