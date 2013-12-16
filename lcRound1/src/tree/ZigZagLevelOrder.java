package tree;

import java.util.ArrayList;
import java.util.Stack;

import common.TreeNode;

public class ZigZagLevelOrder {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null) {
			return result;
		}

		Stack<TreeNode> curStack = new Stack<TreeNode>();
		Stack<TreeNode> nextStack = new Stack<TreeNode>();

		curStack.push(root);
		// pushing from left to right
		boolean leftToRight = true;
		ArrayList<Integer> oneLayer = new ArrayList<Integer>();
		while (!curStack.isEmpty()) {
			TreeNode curNode = curStack.pop();
			if (curNode != null) {
				if (leftToRight) {
					if (curNode.left != null) {
						nextStack.push(curNode.left);
					}
					if (curNode.right != null) {
						nextStack.push(curNode.right);
					}

				} else {
					if (curNode.right != null) {
						nextStack.push(curNode.right);
					}
					if (curNode.left != null) {
						nextStack.push(curNode.left);
					}
				}
				oneLayer.add(curNode.val);
			}

			if (curStack.isEmpty()) {
				ArrayList<Integer> copyLayer = new ArrayList<Integer>(oneLayer);
				result.add(copyLayer);
				oneLayer.clear();
				// reverse direction
				leftToRight = !leftToRight;
				// swap two stacks
				Stack<TreeNode> tmp = curStack;
				curStack = nextStack;
				nextStack = tmp;

			}

		}

		return result;
	}
}
