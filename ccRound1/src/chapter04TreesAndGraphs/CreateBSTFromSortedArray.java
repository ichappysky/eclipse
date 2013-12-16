package chapter04TreesAndGraphs;

import common.TreeNode;

public class CreateBSTFromSortedArray {
	public static TreeNode searchBSF(int[] num) {
		if (num == null) {
			return null;
		}

		return helper(num, 0, num.length - 1);
	}

	private static TreeNode helper(int[] num, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = helper(num, start, mid - 1);
		root.right = helper(num, mid + 1, end);
		return root;
	}

	public static void main(String[] x) {
		int[] num = { 1, 2,3,4,5,6,7,8};
		TreeNode r = searchBSF(num);
		r.print();
	}
}
