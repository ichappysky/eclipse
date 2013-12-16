package tree;

import java.util.ArrayList;
import java.util.Stack;

import common.TreeNode;

public class PostOrderTraversal {

	public void traverseRecursive(final TreeNode r) {
		if (r == null) {
			return;
		}

		traverseRecursive(r.left);
		traverseRecursive(r.right);
		System.out.println(r.val);
	}

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode cur = root;
		TreeNode prev = null;
		while (!stack.isEmpty()) {
			cur = stack.peek();
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null) {
					stack.push(cur.left);
				} else if (cur.right != null) {
					stack.push(cur.right);
				}
			} else if (cur.left == prev) { // can only happen after stack.pop().
				if (cur.right != null) {
					stack.push(cur.right);
				}
			} else { // leaf node or cur.right == prev
				result.add(cur.val);
				stack.pop();
			}
			prev = cur;
		}

		return result;
	}

	// public ArrayList<Integer> postOrderTraversal(TreeNode root) {
	// ArrayList<Integer> result = new ArrayList<Integer>();
	// if (root == null) {
	// return result;
	// }
	//
	// Stack<TreeNode> stack = new Stack<TreeNode>();
	// TreeNode prev = null;
	// TreeNode cur = root;
	// while (!stack.isEmpty() || cur != null) {
	// if (cur != null) {
	// if (cur.left == prev) {
	// stack.push(cur);
	// if (cur.right != null) {
	// stack.push(cur.right);
	// }
	// }
	// } else {
	//
	// }
	// }
	// }

	public static void main(String[] args) {
		final TreeNode testTree = createTestTree();

		PostOrderTraversal t = new PostOrderTraversal();
		t.traverseRecursive(testTree);
		System.out.println("now====");

		System.out.println(t.postorderTraversal(testTree));

	}

	/**
	 * 1 /\ 2 3 /\ /\ 4 5 6 7
	 * 
	 * @return
	 */
	private static TreeNode createTestTree() {
		TreeNode r = new TreeNode(1);
		TreeNode t = new TreeNode(2);
		r.left = t;
		t = new TreeNode(3);
		r.right = t;

		t = new TreeNode(4);
		r.left.left = t;
		t = new TreeNode(5);
		r.left.right = t;
		t = new TreeNode(6);
		r.right.left = t;
		t = new TreeNode(7);
		r.right.right = t;

		return r;
	}
}
