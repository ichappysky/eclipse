package oct03;

import java.util.ArrayList;
import java.util.Stack;

import common.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> curStack = new Stack<TreeNode>();
		Stack<TreeNode> nextStack = new Stack<TreeNode>();
		curStack.push(root);
		ArrayList<Integer> curLayer = new ArrayList<Integer>();
		boolean nextLayerFromLeftToRight = true;
		while (!curStack.isEmpty()) {
			TreeNode cur = curStack.pop();
			curLayer.add(cur.val);
			if (nextLayerFromLeftToRight) {
				if (cur.left != null) {
					nextStack.push(cur.left);
				}
				if (cur.right != null) {
					nextStack.push(cur.right);
				}
			} else {
				if (cur.right != null) {
					nextStack.push(cur.right);
				}
				if (cur.left != null) {
					nextStack.push(cur.left);
				}
			}
			if (curStack.isEmpty()) {
				result.add(curLayer);
				curLayer = new ArrayList<Integer>();

				Stack<TreeNode> tmp = curStack;
				curStack = nextStack;
				nextStack = tmp;
				nextLayerFromLeftToRight=!nextLayerFromLeftToRight;
			}
		}
		return result;
	}

}
