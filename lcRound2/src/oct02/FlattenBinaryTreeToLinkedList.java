package oct02;

import java.util.Stack;

import common.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place. For example, Given
 *    1 
 *   / \ 
 *  2   5 
 * / \   \ 
 *3   4   6 
 * The flattened tree should look like: 1 - 2 - 3 ... -6.
 * 
 * @author yongz
 * 
 */
public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		helperRecursive(root);

	}

	// recursive
	private TreeNode helperRecursive(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode leftEnd = helperRecursive(root.left);
		TreeNode rightEnd = helperRecursive(root.right);
		if (leftEnd != null) {
			leftEnd.right = root.right;
			root.right = root.left;
			root.left = null;
		}
		if (rightEnd == null) {
			return leftEnd == null ? root : leftEnd;
		} else {
			return rightEnd;
		}
	}

	// iterative
	private void helperIterative(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		TreeNode prev = null;
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);

				if (prev != null) {
					prev.left = null;
					prev.right = cur;
				}

				prev = cur;
				cur = cur.left;
			} else {
				cur = stack.pop();
				cur = cur.right;
			}
		}
	}

	public static void main(String[] a) {
		FlattenBinaryTreeToLinkedList t = new FlattenBinaryTreeToLinkedList();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		t.flatten(root);
	}
}
